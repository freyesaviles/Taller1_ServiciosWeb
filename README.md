# Taller 1 - Servicios Web

## API REST - Catálogo de Productos

Proyecto académico desarrollado para la asignatura de Servicios Web.

El proyecto consiste en desarrollar una API REST con Spring Boot para simular un catálogo de productos de la empresa ficticia Café Soluble S.A.

La aplicación permitirá consultar productos y registrar nuevos productos mediante peticiones HTTP. Los datos serán almacenados temporalmente en memoria, por lo tanto, en esta primera versión no se utilizará una base de datos.

---

# 1. Objetivo del proyecto

Diseñar e implementar una API REST utilizando Spring Boot, aplicando conceptos relacionados con:

- Recursos REST.
- Métodos HTTP.
- Rutas o URI.
- Objetos Java.
- JSON.
- Controladores REST.
- Variables dentro de la URI.
- Códigos de estado HTTP.
- Pruebas de servicios mediante Postman.

La API deberá permitir consultar productos existentes, consultar un producto mediante su identificador y registrar nuevos productos.

---

# 2. Tecnologías utilizadas

Para el desarrollo del proyecto se utilizarán las siguientes herramientas:

- Java
- Spring Boot
- Spring Web
- Maven
- IntelliJ IDEA
- Postman
- Git
- GitHub
- draw.io

---

# 3. Recurso principal

El recurso principal de la API será:

`Producto`

Cada objeto Producto representará un producto disponible dentro del catálogo ficticio.

## Atributos de Producto

| Atributo | Tipo Java | Descripción |
|----------|-----------|-------------|
| `id` | `int` | Identificador único del producto. |
| `nombre` | `String` | Nombre del producto. |
| `presentacion` | `String` | Presentación del producto, por ejemplo: 50 g, 100 g o 200 g. |
| `categoria` | `String` | Categoría a la que pertenece el producto. |
| `disponible` | `boolean` | Indica si el producto se encuentra disponible. |

Ejemplo de un producto:

```json
{
  "id": 1,
  "nombre": "Café Tradicional",
  "presentacion": "100 g",
  "categoria": "Café soluble",
  "disponible": true
}