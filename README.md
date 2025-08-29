# 📚 Práctico 2 - App Libros

Aplicación Android desarrollada en **Java** siguiendo el patrón **MVVM** y utilizando **ViewBinding**.  
Forma parte de la entrega del **Práctico 2** de la materia.  

---

## ✨ Funcionalidad

- La app cuenta con **dos Activities**:
  - **MainActivity**: permite buscar un libro por título.
  - **DetalleActivity**: muestra los detalles completos del libro seleccionado.

- Patrón **MVVM**:
  - `BusquedaViewModel` para gestionar la búsqueda.
  - `DetalleViewModel` para mostrar los datos recibidos.

- **Clase Libro** (modelo):
  - Atributos: `código`, `título`, `autor`, `género`, `año`, `descripción`, `imagen`.
  - Implementa `Serializable` para pasarse entre Activities.

- **Repositorio hardcodeado**:
  - `LibroRepositorio` contiene una lista fija de libros.
  - Ejemplos: *El Quijote*, *Cien Años de Soledad*, *1984*, *La Odisea*.

- **Vista Detalle**:
  - Portada dentro de un `CardView` con esquinas redondeadas y sombra.
  - Información del libro: título, autor, código, año, género, descripción.
  - Botón para volver.

---

## 🛠️ Tecnologías usadas
- **Java 17**
- **Android Studio**
- **MVVM + LiveData**
- **ViewBinding**
- **Git / GitHub**

---

## 🚀 Ejecución
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/JorgeFernandezRojoAndres/practico2libros
