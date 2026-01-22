import 'package:flutter/material.dart';
import '../models/tickets.dart';

class DetailScreen extends StatefulWidget {
  final Ticket ticket;

  const DetailScreen({super.key, required this.ticket});

  @override
  State<DetailScreen> createState() => _DetailScreenState();
}

class _DetailScreenState extends State<DetailScreen> {
  int priority = 1;
  late String currentStatus;

  @override
  void initState() {
    super.initState();
    currentStatus = widget.ticket.status;
  }

  Future<void> loadTicket() async {
    await Future.delayed(const Duration(seconds: 2));
  }

  void showMessage(String text) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(text),
        duration: const Duration(seconds: 1, milliseconds: 500),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Detalle'),
        elevation: 0,
      ),
      body: FutureBuilder(
        future: loadTicket(),
        builder: (context, snapshot) {
          if (snapshot.connectionState != ConnectionState.done) {
            return const Center(
              child: CircularProgressIndicator(),
            );
          }

          return GestureDetector(
            onDoubleTap: () {
              setState(() => priority = 1);
              showMessage('Prioridad reiniciada');
            },
            child: SingleChildScrollView(
              child: Padding(
                padding: const EdgeInsets.all(20),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    // Título
                    Text(
                      widget.ticket.title,
                      style: Theme.of(context)
                          .textTheme
                          .headlineSmall
                          ?.copyWith(fontWeight: FontWeight.w600),
                    ),
                    const SizedBox(height: 16),

                    // Descripción
                    Text(
                      widget.ticket.description,
                      style: TextStyle(
                        color: Colors.grey[600],
                        height: 1.6,
                        fontSize: 15,
                      ),
                    ),
                    const SizedBox(height: 24),

                    // Información
                    _buildInfoRow('Estado', currentStatus),
                    const SizedBox(height: 12),
                    _buildInfoRow('Prioridad Original', widget.ticket.priority),
                    const SizedBox(height: 12),
                    _buildInfoRow('Tiempo Estimado', widget.ticket.estimatedTime),
                    const SizedBox(height: 28),

                    // Contador de Prioridad
                    Text(
                      'Prioridad del Técnico',
                      style: Theme.of(context).textTheme.labelLarge,
                    ),
                    const SizedBox(height: 12),
                    Container(
                      padding: const EdgeInsets.symmetric(vertical: 12, horizontal: 16),
                      decoration: BoxDecoration(
                        color: Colors.blue[50],
                        border: Border.all(color: Colors.blue[200]!),
                        borderRadius: BorderRadius.circular(8),
                      ),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          Text(
                            'Nivel: $priority',
                            style: const TextStyle(
                              fontSize: 16,
                              fontWeight: FontWeight.w500,
                            ),
                          ),
                          Text(
                            '(doble tap para reiniciar)',
                            style: TextStyle(fontSize: 12, color: Colors.grey[500]),
                          ),
                        ],
                      ),
                    ),
                    const SizedBox(height: 20),

                    // Botones
                    Row(
                      children: [
                        Expanded(
                          child: ElevatedButton(
                            onPressed: () {
                              setState(() => priority++);
                              showMessage('Prioridad: +1');
                            },
                            child: const Text('Aumentar'),
                          ),
                        ),
                        const SizedBox(width: 12),
                        Expanded(
                          child: OutlinedButton(
                            onPressed: () {
                              if (priority > 1) {
                                setState(() => priority--);
                                showMessage('Prioridad: -1');
                              }
                            },
                            child: const Text('Reducir'),
                          ),
                        ),
                      ],
                    ),
                    const SizedBox(height: 12),
                    SizedBox(
                      width: double.infinity,
                      child: ElevatedButton(
                        onPressed: () {
                          String nuevoStatus = currentStatus;
                          if (currentStatus == 'Abierto') {
                            nuevoStatus = 'En progreso';
                          } else if (currentStatus == 'En progreso') {
                            nuevoStatus = 'Cerrado';
                          } else {
                            nuevoStatus = 'Abierto';
                          }
                          setState(() => currentStatus = nuevoStatus);
                          showMessage('Estado: $nuevoStatus');
                        },
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.green[600],
                        ),
                        child: const Text('Cambiar Estado'),
                      ),
                    ),
                  ],
                ),
              ),
            ),
          );
        },
      ),
    );
  }

  Widget _buildInfoRow(String label, String value) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Text(
          label,
          style: TextStyle(color: Colors.grey[600], fontSize: 14),
        ),
        Text(
          value,
          style: const TextStyle(fontWeight: FontWeight.w500, fontSize: 14),
        ),
      ],
    );
  }
}

