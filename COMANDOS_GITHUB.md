# 📤 Comandos para Subir a GitHub

## Paso 1: Inicializar Git (si no lo has hecho)

```bash
cd "c:\Users\HP\Desktop\2º DAM\PROGRAMACIÓN MULTIMEDIA Y DISPOSITIVOS MÓBILES\HelpDesk\aplicacion"

git init
git add .
git commit -m "Initial commit: HelpDesk Pro Mini - Aplicación Flutter minimalista"
```

## Paso 2: Crear Repositorio en GitHub

1. Ve a https://github.com/new
2. Nombre: `helpdesk-pro-mini`
3. Descripción: `Aplicación Flutter minimalista para gestión de tickets`
4. Visibilidad: Public (o Private si prefieres)
5. NO inicialices con README
6. Crea el repositorio

## Paso 3: Conectar y Subir

```bash
# Reemplaza TU_USUARIO con tu usuario de GitHub
git remote add origin https://github.com/TU_USUARIO/helpdesk-pro-mini.git
git branch -M main
git push -u origin main
```

## Paso 4: Verificar

Visita: `https://github.com/TU_USUARIO/helpdesk-pro-mini`

Deberías ver:
- ✅ Código del proyecto
- ✅ README.md
- ✅ INSTRUCCIONES.md
- ✅ GUIA_USO.md
- ✅ RESUMEN.md
- ✅ carpeta lib/ con el código
- ✅ carpeta android/, ios/, web/, etc.

---

## 📸 Para Agregar Capturas

1. Toma 2 screenshots:
   - Una del Home (lista de tickets)
   - Una del Detail (después de cargar 2s)

2. Crea carpeta `screenshots/` en el proyecto

3. Guarda las imágenes como:
   - `screenshots/home.png`
   - `screenshots/detail.png`

4. Actualiza README.md agregando:

```markdown
## 📸 Capturas de Pantalla

### Home Screen
![Home](screenshots/home.png)

### Detail Screen
![Detail](screenshots/detail.png)
```

5. Haz push:

```bash
git add screenshots/
git commit -m "Add screenshots"
git push
```

---

## 🔄 Actualizaciones Futuras

Si necesitas hacer cambios:

```bash
git add .
git commit -m "Description del cambio"
git push
```

---

## 📋 Checklist Final

- [ ] Código compilado sin errores
- [ ] Repositorio en GitHub (no ZIP)
- [ ] README.md con instrucciones de ejecución
- [ ] 2 capturas de pantalla (Home + Detail)
- [ ] INSTRUCCIONES.md con requisitos
- [ ] GUIA_USO.md con tutorial
- [ ] Todos los archivos .dart presentes
- [ ] pubspec.yaml actualizado
- [ ] .gitignore configurado

---

## ❓ Troubleshooting Git

### Error: "fatal: not a git repository"
```bash
git init
```

### Error: "remote origin already exists"
```bash
git remote remove origin
git remote add origin https://github.com/TU_USUARIO/helpdesk-pro-mini.git
```

### Ver estado actual
```bash
git status
```

### Ver commits
```bash
git log
```

### Cambios no subidos
```bash
git push origin main
```

---

## 💾 Archivos a Incluir en GitHub

✅ **Esenciales:**
- lib/
- android/
- ios/
- web/
- windows/
- macos/
- linux/
- pubspec.yaml
- pubspec.lock
- .gitignore
- README.md

✅ **Documentación:**
- INSTRUCCIONES.md
- GUIA_USO.md
- RESUMEN.md

❌ **Ignorar (automático):**
- .dart_tool/
- build/
- .idea/
- .vscode/
- *.iml

---

## 🎓 Estructura Final en GitHub

```
helpdesk-pro-mini/
├── README.md                    # Principal
├── INSTRUCCIONES.md             # Cómo ejecutar
├── GUIA_USO.md                 # Tutorial de usuario
├── RESUMEN.md                  # Resumen técnico
├── pubspec.yaml
├── analysis_options.yaml
├── lib/
│   ├── main.dart
│   ├── models/
│   ├── data/
│   ├── screens/
│   └── widgets/
├── android/
├── ios/
├── web/
├── windows/
├── macos/
├── linux/
├── test/
└── screenshots/
    ├── home.png
    └── detail.png
```

---

**¡Listo para entrega!** 🚀

Copia los comandos anterior en la terminal PowerShell y tu proyecto estará en GitHub.
