class Ticket {
  final int id;
  final String title;
  final String description;
  final String status;
  final String priority;
  final String estimatedTime;
  final String category;

  Ticket({
    required this.id,
    required this.title,
    required this.description,
    required this.status,
    this.priority = 'Media',
    this.estimatedTime = '2h',
    this.category = 'General',
  });
}
