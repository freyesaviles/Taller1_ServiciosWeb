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


# 18. Aporte técnico del Integrante 1

## Rama: Max

El Integrante 1 estuvo encargado principalmente del diseño técnico y modelado inicial de la API REST.

### Trabajo realizado

- Definición del recurso `Producto`.
- Definición de los atributos `id`, `nombre`, `presentacion`, `categoria` y `disponible`.
- Diseño de las rutas de la API REST.
- Definición de los métodos HTTP correspondientes a cada operación.
- Definición de los códigos de estado HTTP `200 OK`, `201 Created` y `404 Not Found`.
- Justificación técnica de las decisiones tomadas para el diseño de la API.
- Creación de la clase `Producto`.
- Implementación de los constructores de `Producto`.
- Implementación de getters y setters.
- Documentación de la representación de los productos mediante JSON.

La implementación del controlador y los endpoints será realizada posteriormente por el integrante responsable de la implementación REST.