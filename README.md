# Sistema de Registro y Autenticación de Usuarios

Este proyecto es una aplicación de escritorio desarrollada en **Java** con **Swing** para la gestión de registro y autenticación de usuarios. Está diseñada para garantizar la seguridad y validez de los datos ingresados, mediante validaciones avanzadas y controles de calidad.

```plaintext
proaula
├── controller
│   └── Controladores encargados de gestionar la lógica entre la vista y los modelos.
├── imagenes
│   └── Archivos multimedia utilizados en la interfaz gráfica.
├── librerias
│   └── Dependencias externas o utilidades adicionales.
├── model
│   ├── Clases que representan las entidades del sistema.
│   ├── Implementaciones del patrón DAO para el acceso a la base de datos.
│   └── Utilidades como la encriptación de contraseñas y sesiones.
├── resources
│   └── Archivos de configuración y datos adicionales.
├── sombra
│   └── Elementos auxiliares para efectos visuales.
├── vista
│   └── Interfaces gráficas desarrolladas con Java Swing.
└── Proaula.java
    └── Clase principal para ejecutar el proyecto.
```
## Características

- **Registro de usuarios**:
  - Validación de campos obligatorios.
  - Detección de caracteres repetidos en nombres y apellidos.
  - Filtro de palabras inapropiadas en los datos ingresados.
  - Verificación del formato del correo electrónico.
- **Inicio de sesión**:
  - Autenticación mediante nombre de usuario y contraseña.
  - Validación contra una base de datos MySQL.
- **Gestión de datos**:
  - Almacenamiento seguro en una base de datos.
  - Función para redirigir a diferentes ventanas dependiendo de la acción.

## Tecnologías utilizadas

- **Lenguaje**: Java
- **IDE**: NetBeans
- **Base de datos**: MySQL
- **Bibliotecas**: Java Swing para la interfaz gráfica.

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

1. **Java JDK** (versión 8 o superior).
2. **NetBeans IDE**.
3. **Servidor MySQL**.
4. **Driver JDBC para MySQL** (conectado al proyecto).

## Instalación

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tu_usuario/tu_proyecto.git
