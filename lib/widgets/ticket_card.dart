import 'package:flutter/material.dart';
import '../models/tickets.dart';

class TicketCard extends StatelessWidget {
  final Ticket ticket;
  final VoidCallback onTap;

  const TicketCard({
    required this.ticket,
    required this.onTap,
    super.key,
  });
    //cada color indica el estado en el que etá la incidencia
  Color _getStatusColor(String status) {
    switch (status.toLowerCase()) {
      case 'abierto':
        return Colors.red;
      case 'en progreso':
        return Colors.orange;
      case 'cerrado':
        return Colors.green;
      default:
        return Colors.grey;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 6),
      elevation: 1,
      child: ListTile(
        leading: Container(
          width: 12,
          height: 12,
          decoration: BoxDecoration(
            color: _getStatusColor(ticket.status),
            shape: BoxShape.circle,
          ),
        ),
        title: Text(ticket.title),
        subtitle: Text(ticket.status, style: TextStyle(fontSize: 12, color: Colors.grey[600])),
        trailing: const Icon(Icons.chevron_right, size: 20),
        onTap: onTap,
      ),
    );
  }
}
