import 'package:flutter/material.dart';

class SettingsScreen extends StatelessWidget {
  const SettingsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Ajustes'),
        elevation: 0,
      ),
      body: ListView(
        padding: const EdgeInsets.symmetric(vertical: 12, horizontal: 16),
        children: [
          _buildSettingsTile(
            icon: Icons.palette,
            title: 'Tema',
            subtitle: 'Claro',
          ),
          _buildSettingsTile(
            icon: Icons.notifications,
            title: 'Notificaciones',
            subtitle: 'Activadas',
          ),
          _buildSettingsTile(
            icon: Icons.security,
            title: 'Privacidad',
            subtitle: 'Encriptado',
          ),
          _buildSettingsTile(
            icon: Icons.info,
            title: 'Versión',
            subtitle: 'v1.0.0',
          ),
          const SizedBox(height: 32),
          Center(
            child: Text(
              'HelpDesk',
              style: Theme.of(context).textTheme.labelSmall,
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildSettingsTile({
    required IconData icon,
    required String title,
    required String subtitle,
  }) {
    return Card(
      margin: const EdgeInsets.symmetric(vertical: 8),
      elevation: 0,
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(8),
        side: BorderSide(color: Colors.grey[300]!),
      ),
      child: ListTile(
        leading: Icon(icon, size: 24),
        title: Text(title, style: const TextStyle(fontWeight: FontWeight.w500)),
        subtitle: Text(subtitle, style: TextStyle(fontSize: 13, color: Colors.grey[500])),
      ),
    );
  }
}
