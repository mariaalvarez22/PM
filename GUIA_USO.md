# 👤 Guía de Uso - HelpDesk Pro Mini

## 🎯 Objetivo de la App

Sistema de gestión de tickets minimalista para demostrar dominio de Flutter.

---

## 📱 Pantallas y Funciones

### 🏠 **Pantalla 1: Home (Lista de Tickets)**

**¿Qué ves?**
- AppBar con título "Tickets"
- Botón ⚙️ (Ajustes) en la esquina superior derecha
- Lista de 8 tickets (Cards)
- Cada ticket muestra:
  - 🔴 Punto de color (indica estado)
  - Título del ticket
  - Estado actual
  - ► Indicador de navegación

**¿Qué puedes hacer?**
- ✅ **Tocar un ticket** → Va al detalle
- ✅ **Tocar ⚙️** → Va a Ajustes

**Ejemplo de estados:**
- 🔴 **Rojo** = Abierto
- 🟠 **Naranja** = En progreso
- 🟢 **Verde** = Cerrado

---

### 📋 **Pantalla 2: Detail (Detalle del Ticket)**

**Fase 1: Cargando (2 segundos)**
- Muestra spinner de carga
- Simula descarga de datos desde servidor

**Fase 2: Contenido Cargado**

**Información del Ticket:**
- Título destacado
- Descripción completa
- Tabla de información:
  - Estado actual
  - Prioridad del ticket
  - Categoría
  - Tiempo estimado

**Sección: Prioridad del Técnico**
```
┌──────────────────────┐
│ Prioridad del Técnico│
│ Nivel: X             │
│ (doble tap reinicia) │
└──────────────────────┘
```
- Muestra contador (comienza en 1)
- **DOBLE TAP**: Reinicia a nivel 1 ✨

**Botones de Acción:**

1. **[Aumentar]** + [Reducir]
   - Incrementa/decrementa prioridad del técnico
   - Mínimo: 1 | Máximo: sin límite
   - Cada acción muestra confirmación

2. **[Cambiar Estado]** (verde)
   - Cicla: Abierto → En progreso → Cerrado → Abierto
   - Actualiza el estado del ticket
   - Muestra confirmación

**Feedback (SnackBar abajo):**
- ✅ "Prioridad: +1"
- ✅ "Prioridad: -1"
- ✅ "Estado: En progreso"
- etc...

**¿Qué puedes hacer?**
- ✅ **Tocar [Aumentar]** → priority++
- ✅ **Tocar [Reducir]** → priority--
- ✅ **Doble tap en el nivel** → priority = 1
- ✅ **Tocar [Cambiar Estado]** → siguiente estado
- ✅ **Tocar ◀** (atrás) → Vuelve a Home

---

### ⚙️ **Pantalla 3: Settings (Ajustes)**

**Opciones disponibles:**

1. **🎨 Tema** → Claro
2. **🔔 Notificaciones** → Activadas  
3. **🔒 Privacidad** → Encriptado
4. **ℹ️ Versión** → v1.0.0

Al pie: "HelpDesk Pro Mini"

**¿Qué puedes hacer?**
- ✅ **Ver opciones** (sin funcionalidad interactiva - es UI de demostración)
- ✅ **Tocar ◀** → Vuelve a Home

---

## 🎮 Tutorial de Uso

### Escenario 1: Aumentar Prioridad de un Ticket

1. En Home, toca **"Error de login"**
2. Espera 2 segundos a que cargue
3. Verás: "Nivel: 1"
4. Toca **[Aumentar]** 3 veces
5. Verás: "Nivel: 4"
6. Cada tap muestra: ✅ "Prioridad: +1"

### Escenario 2: Reiniciar Contador

1. En Detail, con contador en "Nivel: 4"
2. **Toca 2 veces rápido** sobre el nivel (doble tap)
3. Verifica: Vuelve a "Nivel: 1"
4. Muestra confirmación: ✅ "Prioridad reiniciada"

### Escenario 3: Cambiar Estado de Ticket

1. En Detail, verás "Estado: Abierto"
2. Toca **[Cambiar Estado]**
3. Ahora dice: "Estado: En progreso"
4. Toca de nuevo
5. Ahora dice: "Estado: Cerrado"
6. Una vez más: "Estado: Abierto"

### Escenario 4: Ir a Ajustes

1. En Home, toca ⚙️ en la esquina
2. Verás 4 opciones (solo demo, no cambian nada)
3. Toca ◀ para volver

---

## 🔍 Observa Estos Detalles

### Indicadores Visuales

**Punto de color en Home:**
```
🔴 Rojo    = Abierto (problema activo)
🟠 Naranja = En progreso (trabajando en ello)
🟢 Verde   = Cerrado (resuelto)
```

**Textos:**
- Títulos: Grandes y negros (importante)
- Estados: Grises (secundario)
- Botones: Claros y accesibles

**Espaciados:**
- Márgenes generosos (no apretado)
- Cards separadas y limpias
- Sin exceso de decoración

### Feedback en Acciones

Cada botón que tocas:
- ✅ Muestra SnackBar abajo (confirmación)
- ✅ Cambia el valor visible
- ✅ Se mantiene 1.5 segundos

### Carga Asincrónica

En Detail:
- **Primer vistazo:** Spinner + "Cargando..."
- **Después 2s:** Contenido completo
- Simula descarga desde servidor

---

## 🎓 Qué Demuestra Esta App

✅ **Navegación**: Moverte entre pantallas  
✅ **Estado dinámico**: Valores que cambian  
✅ **Async/Await**: Cargas simuladas  
✅ **Interactividad**: Botones y gestos  
✅ **Feedback**: Confirmaciones visuales  
✅ **Diseño limpio**: UI minimalist pero profesional  
✅ **Código organizado**: Fácil de entender y mantener

---

## ⌨️ Atajos y Tips

- **Para ir atrás:** Toca ◀ o usa gesto "swipe back"
- **Para reiniciar contador:** Doble tap (muy rápido)
- **Para ver cambios:** Todos los cambios son inmediatos
- **Sin internet:** Funciona 100% offline

---

## 🐛 Troubleshooting

### "No se ve nada, solo spinner"
- Espera 2 segundos (es normal)
- El FutureBuilder está cargando

### "¿Por qué no puedo ir más abajo de 1 en prioridad?"
- Es intencional: no tiene sentido tener prioridad 0
- Botón "-" se desactiva cuando llegas a 1

### "¿Los cambios se guardan?"
- No, es una app de demo
- Al recargar vuelve al estado inicial

### "¿Qué pasa si doble tap en la pantalla normal?"
- Nada (solo funciona en el contador)
- Es un detalle de UX

---

## 📊 8 Tickets Disponibles

1. **Error de login** - Abierto, Crítica
2. **Pantalla en blanco** - Abierto, Crítica
3. **Error de pago** - En progreso, Alta
4. **Bug visual** - Cerrado, Baja
5. **Crash inesperado** - Abierto, Alta
6. **Notificaciones push** - En progreso, Media
7. **Rendimiento lento** - Abierto, Media
8. **Sincronización** - En progreso, Media

---

## 🎨 Colores Usados

- **Primario**: Indigo (AppBar, botones)
- **Secundario**: Gris (textos secundarios)
- **Estados**:
  - Rojo: Problemas abiertos
  - Naranja: En proceso
  - Verde: Resuelto
- **Fondo**: Blanco limpio

---

## 🚀 Resumen Rápido

```
HOME (8 tickets)
  ↓ toca un ticket
DETAIL (carga 2s)
  ├─ +/- prioridad (setState)
  ├─ doble tap (reset)
  ├─ cambiar estado (ciclo)
  └─ SnackBars (feedback)
  
SETTINGS (4 opciones)
  └─ solo demo UI
```

---

**¡Listo para explorar!** 🚀
