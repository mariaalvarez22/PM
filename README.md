# 📱 HelpDesk Pro Mini

Aplicación Flutter minimalista que demuestra dominio de widgets esenciales, gestión de estado, navegación y async operations.

## ✅ Requisitos Cumplidos

### Obligatorios
- ✓ **2 pantallas** con navegación: Home (lista) + Detail (detalle)
- ✓ **8+ tickets** con dataset completo
- ✓ **FutureBuilder** con carga simulada de 2 segundos
- ✓ **setState()** - Contador de prioridad (incrementar/decrementar)
- ✓ **2+ botones** que cambian estado
- ✓ **SnackBar** al pulsar acciones
- ✓ **UI cuidada** con Padding, SizedBox, textos legibles

### Mejoras Implementadas
- ✓ **3era pantalla**: Ajustes limpia y funcional
- ✓ **Cards, Icons, ListTiles**: Diseño minimalista bien estructurado
- ✓ **GestureDetector**: Doble tap para reiniciar contador de prioridad
- ✓ **Código organizado**: Widgets separados, nombres claros, estructura limpia
- ✓ **Jerarquía visual**: Espaciados coherentes, tipografía consistente
- ✓ **Material 3**: Tema moderno con colores naturales

## 🎨 Diseño

**Filosofía**: Minimalismo funcional
- Colores neutros (Indigo primario)
- Espaciados generosos y consistentes
- Sin decoración excesiva
- Foco en funcionalidad y legibilidad
- Cards simples con bordes sutiles

## 📁 Estructura

```
lib/
├── main.dart                    # App raíz con ThemeData
├── models/
│   └── tickets.dart            # Modelo Ticket
├── data/
│   └── ticket_data.dart        # 8 tickets (dataset fijo)
├── screens/
│   ├── home_screen.dart        # Lista con NavigationBuilder
│   ├── detail_screen.dart      # Detalle + FutureBuilder + setState
│   └── settings_screen.dart    # Configuración
└── widgets/
    └── ticket_card.dart        # Widget reutilizable para lista
```

## 🚀 Ejecución

### Web (Chrome)
```bash
cd "c:\Users\HP\Desktop\2º DAM\PROGRAMACIÓN MULTIMEDIA Y DISPOSITIVOS MÓBILES\HelpDesk\aplicacion"
flutter pub get
flutter run -d chrome
```

### Android
```bash
flutter run -d android
```

### Windows (requiere Visual Studio)
```bash
flutter run -d windows
```

## 🎮 Funcionalidades

### Pantalla Home
- Lista de 8 tickets con Cards
- Punto de color indicando estado (Rojo: Abierto, Naranja: En progreso, Verde: Cerrado)
- Navegación al tocar un ticket
- Botón de ajustes en AppBar

### Pantalla Detail
- **Carga asincrónica**: 2s con FutureBuilder + spinner
- **Información del ticket**: Título, descripción, metadatos
- **Contador de prioridad**: 
  - Botón "Aumentar" (+1)
  - Botón "Reducir" (-1, mínimo 1)
  - Doble tap para reiniciar a 1
  - Indicador visual en container
- **Cambiar estado**: Cicla Abierto → En progreso → Cerrado
- **Feedback**: SnackBar para cada acción

### Pantalla Settings
- 4 opciones: Tema, Notificaciones, Privacidad, Versión
- Iconos descriptivos
- Cards simples y legibles
- Pie de página con branding

## 💡 Detalles Técnicos

### Widgets Utilizados
- `FutureBuilder` - Carga asincrónica con fallback
- `GestureDetector` - Detección de doble tap
- `setState()` - Gestión de estado local
- `Card`, `ListTile`, `Icons` - Componentes de UI
- `ScaffoldMessenger` - SnackBar
- `Navigator` - Navegación entre pantallas

### Principios de Diseño
- **Consistencia**: Colores y espaciados uniformes
- **Jerarquía**: Títulos destacados, subtextos grises
- **Accesibilidad**: Textos legibles, buenas dimensiones
- **Minimalismo**: Solo lo necesario, nada superfluo
- **Feedback visual**: SnackBars para confirmación de acciones

## 📋 Datos de Ejemplo

8 tickets con información realista:
1. Error de login (Abierto, Crítica)
2. Pantalla en blanco (Abierto, Crítica)
3. Error de pago (En progreso, Alta)
4. Bug visual (Cerrado, Baja)
5. Crash inesperado (Abierto, Alta)
6. Notificaciones push (En progreso, Media)
7. Rendimiento lento (Abierto, Media)
8. Sincronización (En progreso, Media)

---

**Nota**: Aplicación desarrollada con Flutter y Material Design 3 para demostración de competencias en desarrollo móvil.

