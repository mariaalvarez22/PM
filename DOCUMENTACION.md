# 🎯 HelpDesk Pro Mini

Aplicación Flutter para demostrar dominio de widgets, estado, eventos, navegación y FutureBuilder.

## 📋 Características Implementadas

### ✅ Requisitos Obligatorios

- **2 Pantallas con navegación**
  - ✓ Pantalla de inicio (lista de tickets)
  - ✓ Pantalla de detalle (con manejo de estados)
  - ✓ Pantalla de ajustes (tercera pantalla)

- **Dataset de 8+ Tickets**
  - ✓ 8 tickets con datos reales en `lib/data/ticket_data.dart`
  - ✓ Información completa: ID, título, descripción, estado, prioridad, tiempo estimado, categoría

- **En Pantalla de Detalle**
  - ✓ **FutureBuilder** con carga simulada de 2 segundos
  - ✓ **setState()** - Contador de prioridad (incrementar/decrementar)
  - ✓ **2 Botones** que cambian el estado (+/- prioridad)
  - ✓ **Botón adicional** para cambiar estado del ticket (Abierto → En progreso → Cerrado)
  - ✓ **SnackBar** al pulsar cualquier acción con emojis
  - ✓ **GestureDetector** - Doble tap para reiniciar contador
  - ✓ **UI mejorada** con Padding, SizedBox, textos legibles

### 🎨 Mejoras Implementadas

- **Componentes visuales avanzados**
  - ✓ Card con elevation y borderRadius redondeados
  - ✓ ListTile con iconos y chips
  - ✓ CircleAvatar con colores dinámicos según estado
  - ✓ Chips para mostrar categoría, tiempo estimado y estado
  - ✓ Container con decoraciones personalizadas
  - ✓ Botones ElevatedButton con iconos y colores temáticos

- **Pantalla de Ajustes Mejorada**
  - ✓ Card para cada opción de configuración
  - ✓ Iconos en containers coloreados
  - ✓ Cuatro opciones: Tema, Notificaciones, Privacidad, Acerca de

- **Widget Reutilizable TicketCard**
  - ✓ Componente personalizado para mostrar tickets
  - ✓ Colores dinámicos según estado (Rojo: Abierto, Naranja: En progreso, Verde: Cerrado)
  - ✓ Iconos descriptivos por estado
  - ✓ Chips informativos integrados

## 🚀 Cómo Ejecutar

### Opción 1: Windows (requiere Visual Studio)
```bash
cd "c:\Users\HP\Desktop\2º DAM\PROGRAMACIÓN MULTIMEDIA Y DISPOSITIVOS MÓBILES\HelpDesk\aplicacion"
flutter pub get
flutter run -d windows
```

### Opción 2: Web (Chrome)
```bash
cd "c:\Users\HP\Desktop\2º DAM\PROGRAMACIÓN MULTIMEDIA Y DISPOSITIVOS MÓBILES\HelpDesk\aplicacion"
flutter pub get
flutter run -d chrome
```

### Opción 3: Android
```bash
cd "c:\Users\HP\Desktop\2º DAM\PROGRAMACIÓN MULTIMEDIA Y DISPOSITIVOS MÓBILES\HelpDesk\aplicacion"
flutter pub get
flutter run -d android
```

## 📁 Estructura del Proyecto

```
lib/
├── main.dart                    # Aplicación principal
├── models/
│   └── tickets.dart            # Modelo Ticket con campos extendidos
├── data/
│   └── ticket_data.dart        # Dataset de 8 tickets
├── screens/
│   ├── home_screen.dart        # Pantalla de lista
│   ├── detail_screen.dart      # Pantalla de detalle con FutureBuilder
│   └── settings_screen.dart    # Pantalla de ajustes
└── widgets/
    └── ticket_card.dart        # Widget reutilizable para tarjetas
```

## 🎮 Funcionalidades por Pantalla

### Pantalla Home (Lista)
- Visualiza los 8 tickets en una lista
- Cada ticket muestra:
  - Icono de estado (círculo de color)
  - Título del ticket
  - Chips con estado y prioridad
  - Indicador de navegación
- Botón de ajustes en el AppBar
- Navegación al detalle al pulsar un ticket

### Pantalla Detail (Detalle)
- **Carga asincrónica** (2s con FutureBuilder + CircularProgressIndicator)
- Información del ticket:
  - Título con estilo destacado
  - Chips de categoría, tiempo estimado y estado
  - Descripción en Card
  - Contador de prioridad
- **Contador de Prioridad**:
  - Mostrado en container destacado
  - Botón "+" para aumentar
  - Botón "-" para reducir (no puede bajar de 1)
  - Doble tap para reiniciar a 1
- **Botón Cambiar Estado**:
  - Rota entre: Abierto → En progreso → Cerrado
- **SnackBar** flotante con emojis en cada acción

### Pantalla Settings (Ajustes)
- 4 opciones en Cards:
  - Tema (azul)
  - Notificaciones (verde)
  - Privacidad (naranja)
  - Acerca de (púrpura)
- Pie de página con copyright

## 🎨 Paleta de Colores

- **Primario**: Indigo
- **Secundario**: Grey[100] (fondo)
- **Estados**:
  - Abierto: Rojo
  - En progreso: Naranja
  - Cerrado: Verde
- **Acciones**: Verde (aumentar), Naranja (reducir), Púrpura (cambiar estado)

## 📦 Dependencias

- `flutter/material.dart` - UI framework
- `flutter_test/flutter_test.dart` - Testing

## 👨‍💼 Autor

Desarrollado como proyecto de HelpDesk Pro Mini para demostración de competencias Flutter.

---

**Nota**: Los colores y layouts están optimizados para una experiencia visual moderna y profesional.
