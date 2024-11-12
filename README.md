# PequeLemon App 🍋

PequeLemon es una aplicación de menú digital diseñada para facilitar la navegación y selección de platos. Los usuarios pueden explorar el menú, ver detalles de cada plato y personalizar su experiencia mediante un registro inicial.

## Características

- **Registro de usuario**: Al iniciar la aplicación, el usuario se registra con sus datos personales, que se guardan para mostrarse posteriormente en la pantalla de perfil.
- **Exploración de menú**: Navega por una lista de platos con imágenes, descripciones y precios.
- **Filtros de categoría**: Filtra los platos por categorías como Entradas, Platos, Postres y Bebidas.
- **Búsqueda**: Encuentra platos rápidamente con una barra de búsqueda.
- **Detalles de plato**: Accede a una vista detallada de cada plato con una imagen ampliada y descripción.
- **Perfil de usuario**: Visualiza y edita la información ingresada durante el registro inicial.

## Tecnologías utilizadas

- **Lenguaje**: Kotlin
- **Framework**: Jetpack Compose
- **Dependencias**: Coil para carga de imágenes, Navigation para navegar entre pantallas, DataStore para almacenamiento de datos de usuario.
- **UI personalizada**: Uso de Material Design y temas personalizados de la aplicación.

## Configuración del proyecto

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tu-usuario/PequeLemon.git
   cd PequeLemon
   
2. Abre el proyecto en Android Studio:
   - Asegúrate de tener Android Studio Arctic Fox o una versión superior instalada.

3. Sincroniza las dependencias:
   - Ve al archivo `build.gradle` del módulo de la app y selecciona **Sync Now** para descargar todas las dependencias necesarias.

4. Configura un emulador o dispositivo físico:
   - Conecta un dispositivo físico o configura un emulador en Android Studio para ejecutar la app.

5. Ejecuta la aplicación:
   - En la barra de herramientas de Android Studio, selecciona tu dispositivo y haz clic en **Run** para compilar y lanzar la aplicación.

## Capturas de pantalla

A continuación se muestran algunas capturas de pantalla clave de la aplicación:

| Pantalla de Registro               | Pantalla de Inicio               | Detalles del plato                   | Perfil de Usuario                |
|------------------------------------|----------------------------------|--------------------------------|----------------------------------|
| ![Registro](/register.jpg) | ![Inicio](/home.jpg) | ![Detalles del plato](/dishDetails.jpg) | ![Perfil de Usuario](/profile.jpg) |

Estas pantallas muestran el flujo de la aplicación, desde el registro inicial hasta la exploración del menú y la visualización del perfil del usuario.

## Contribuciones

Las contribuciones son bienvenidas. Para contribuir:

1. Realiza un fork de este repositorio.
2. Crea una nueva rama para tu funcionalidad (`git checkout -b nueva-funcionalidad`).
3. Realiza commit de tus cambios (`git commit -m 'Agregar nueva funcionalidad'`).
4. Sube tu rama (`git push origin nueva-funcionalidad`).
5. Abre un Pull Request y describe los cambios realizados.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

