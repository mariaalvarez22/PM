# 🎯 Instrucciones de Entrega

## Proyecto: HelpDesk Pro Mini (Minimalista)

Este es el proyecto final de Flutter demostrando dominio de widgets, estado, navegación y operaciones asincrónicas.

---

## ✅ Checklist de Requisitos

### Requisitos Obligatorios (Aprobado)
- [x] App con 2 pantallas (lista + detalle) con navegación
- [x] Mínimo 8 tickets (dataset fijo)
- [x] FutureBuilder con carga simulada 2+ segundos
- [x] Contador con setState (prioridad +/-)
- [x] 2+ botones que cambian estado
- [x] 1 SnackBar al pulsar una acción
- [x] UI cuidada: Padding, SizedBox, textos legibles

### Mejoras Implementadas (Sobresaliente)
- [x] 3era pantalla de Ajustes
- [x] Cards, Icons, ListTiles con estilo
- [x] GestureDetector (doble tap = reset contador)
- [x] UI pulida: Jerarquía visual, coherencia, espaciados
- [x] Código limpio: Widgets separados, nombres descriptivos
- [x] Material 3 con tema coherente

---

## 🚀 Cómo Ejecutar

### 1. Clonar / Descargar el Repositorio
```bash
git clone <URL_DEL_REPOSITORIO>
cd aplicacion
```

### 2. Instalar Dependencias
```bash
flutter pub get
```

### 3. Ejecutar en Chrome (Recomendado - Sin dependencias)
```bash
flutter run -d chrome
```

### 4. Ejecutar en Android
```bash
flutter run -d android
```

### 5. Ejecutar en Windows (Requiere Visual Studio)
```bash
flutter run -d windows
```

---

## 📱 Características Principales

### Pantalla Home (Lista)
✅ Muestra 8 tickets en una lista limpia
✅ Cada ticket tiene un punto de color según estado
✅ Al pulsar, navega a detalle
✅ Botón de Ajustes en AppBar

### Pantalla Detail (Detalle)
✅ Carga asincrónica 2s (FutureBuilder + CircularProgressIndicator)
✅ Muestra información completa del ticket
✅ **Contador de Prioridad**:
   - Botón "Aumentar" para incrementar
   - Botón "Reducir" para decrementar (mínimo 1)
   - Doble tap en el contenedor para reiniciar a 1
   - SnackBar de confirmación en cada acción
✅ **Botón "Cambiar Estado"**:
   - Cicla entre: Abierto → En progreso → Cerrado → Abierto
   - SnackBar con nuevo estado

### Pantalla Settings (Ajustes)
✅ 4 opciones configurables: Tema, Notificaciones, Privacidad, Versión
✅ Iconos descriptivos
✅ Branding del app al pie

---

## 📁 Estructura de Archivos

```
lib/
├── main.dart                    # Punto de entrada
├── models/
│   └── tickets.dart            # Modelo de datos
├── data/
│   └── ticket_data.dart        # 8 tickets (dataset fijo)
├── screens/
│   ├── home_screen.dart        # Pantalla de lista
│   ├── detail_screen.dart      # Pantalla de detalle
│   └── settings_screen.dart    # Pantalla de ajustes
└── widgets/
    └── ticket_card.dart        # Componente reutilizable
```

---

## 🎨 Diseño Visual

- **Paleta**: Colores neutros - Indigo primario
- **Espaciado**: Generoso y consistente (16px, 20px)
- **Tipografía**: Material 3 - Legible y jerárquica
- **Componentes**: Cards simples, ListTiles, Iconos
- **Filosofía**: Minimalismo funcional (solo lo necesario)

---

## 💻 Requisitos del Sistema

- Flutter 3.0+
- Dart 3.0+
- Un navegador moderno (para ejecutar en web)
- Android SDK (para Android)
- Visual Studio Community (para Windows)

---

## 📸 Capturas de Pantalla

### Home Screen
- Lista de 8 tickets con Cards
- Puntos de color por estado
- AppBar con título y botón de ajustes

### Detail Screen
- Título prominente
- Descripción clara
- Información estructurada
- Contador de prioridad interactivo
- Botones de acción principales

### Settings Screen
- 4 opciones en Cards
- Iconos claros
- Diseño limpio

---

## 🎓 Conceptos Demostrando

✓ **Widgets**: Card, ListTile, AppBar, FloatingActionButton, TextField
✓ **Navegación**: Navigator.push/pop, MaterialPageRoute
✓ **Estado**: StatefulWidget, setState(), FutureBuilder
✓ **Async**: Future, FutureBuilder, delayed()
✓ **Gestos**: GestureDetector, onDoubleTap, onTap
✓ **Feedback**: SnackBar, ScaffoldMessenger
✓ **Temas**: ThemeData, Material 3, ColorScheme
✓ **Estructura**: Código organizado, widgets separados

---

## 🔧 Notas Técnicas

- **FutureBuilder**: Simula carga de datos con `Future.delayed(2s)`
- **GestureDetector**: Doble tap en el contador reinicia a 1
- **setState()**: Actualiza contador y estado del ticket
- **SnackBar**: Feedback inmediato en cada acción
- **Material 3**: Tema moderno con `useMaterial3: true`

---

## 📝 Requisitos de Entrega

1. ✅ Código en GitHub (no ZIP)
2. ✅ README.md con instrucciones
3. ✅ 2 capturas: Home + Detail (tras carga)
4. ✅ Tercera pantalla (Ajustes)
5. ✅ Cards, Icons, ListTiles
6. ✅ GestureDetector (doble tap)

---

**Última actualización**: 2026-01-19  
**Versión**: 1.0  
**Estado**: Completado ✅
