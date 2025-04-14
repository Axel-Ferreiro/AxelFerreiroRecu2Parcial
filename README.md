# 🎶 Proyecto de Gestión de Eventos Musicales

## 💡 Descripción

Este proyecto simula un sistema de gestión de eventos musicales, donde se pueden crear, ordenar, filtrar, guardar y cargar eventos desde archivos.  
El código está escrito en **Java** aplicando conceptos clave de la **Programación Orientada a Objetos (POO)** y manejo de archivos.

---

## 📚 Temas de Java aplicados

### 🔹 Herencia
- `EventoMusical` extiende la clase abstracta `Evento`.

### 🔹 Clases abstractas
- `Evento` define estructura y comportamiento base para los eventos.

### 🔹 Interfaces
- `CSVSerializable`: para exportar objetos a CSV.
- `Gestionable<T>`: define operaciones genéricas (`agregar`, `eliminar`, `filtrar`, etc.).
- `Serializable`: permite guardar/leer objetos en binario.
- `Comparable<T>`: para ordenar objetos.
- Interfaces funcionales: `Predicate`, `Function`, `Comparator`.

### 🔹 Genéricos (`<T>`)
- `GestorEventos<T>` y `Gestionable<T>` usan genéricos con restricciones (`T extends CSVSerializable & Comparable<T>`).

### 🔹 Enumeraciones (`enum`)
- `GeneroMusical`: contiene géneros como `ROCK`, `POP`, `CLASICA`, etc.

### 🔹 Manejo de archivos
- 📄 CSV (texto): con `BufferedReader` y `BufferedWriter`.
- 💾 Binario: con `ObjectInputStream` y `ObjectOutputStream`.

### 🔹 Colecciones
- Uso de `ArrayList<T>` para almacenar y manipular eventos.

### 🔹 Lambdas y funciones funcionales
- `Predicate<T>` → filtrar eventos.
- `Function<String, T>` → transformar línea CSV a objeto.
- `Comparator<T>` → ordenar con distintos criterios.

### 🔹 Manejo de excepciones
- Validación de índices con `IndexOutOfBoundsException`.
- Control de errores de archivos: `IOException`, `ClassNotFoundException`.

### 🔹 Sobrescritura de métodos (`@Override`)
- Métodos como `toString`, `compareTo`, `toCSV`, etc.

### 🔹 Modularización
- Separación clara de responsabilidades en clases e interfaces.

---

## 🧪 Funcionalidades

- ✅ Agregar y eliminar eventos musicales.
- ✅ Mostrar todos los eventos.
- ✅ Ordenar eventos (natural o con comparator).
- ✅ Filtrar eventos por condición (ej: género, artista).
- ✅ Guardar en archivo CSV.
- ✅ Cargar desde archivo CSV.
- ✅ Guardar y cargar en binario.

---

## 🧩 Estructura de clases

