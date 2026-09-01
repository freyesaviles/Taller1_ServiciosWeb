# Taller 1 - Servicios Web

## API REST - Catálogo de Productos

Proyecto académico desarrollado para la asignatura de Servicios Web. La aplicación simula un servicio REST para el catálogo de productos de la empresa ficticia **Café Soluble S.A.** El nombre, la situación, los datos y la solución se utilizan exclusivamente con fines académicos.

La API permite consultar y registrar productos mediante peticiones HTTP. Los datos se almacenan temporalmente en memoria: no se utiliza una base de datos y los registros nuevos se pierden al reiniciar la aplicación.

## 1. Objetivo

Diseñar, implementar y probar una API REST con Spring Boot, aplicando recursos REST, métodos HTTP, URI, objetos Java, JSON, controladores, variables de ruta, códigos de estado y pruebas con Postman.

## 2. Tecnologías

- Java 17.
- Spring Boot y Spring Web MVC.
- Maven.
- IntelliJ IDEA.
- Postman.
- Git y GitHub.
- draw.io.

## 3. Recurso Producto

| Atributo | Tipo Java | Descripción |
|---|---|---|
| `id` | `int` | Identificador único del producto. |
| `nombre` | `String` | Nombre ficticio del producto. |
| `presentacion` | `String` | Presentación, por ejemplo, 50 g, 100 g o 200 g. |
| `categoria` | `String` | Categoría ficticia del producto. |
| `disponible` | `boolean` | Indica si el producto se encuentra disponible. |

```json
{
  "id": 1,
  "nombre": "Café Tradicional",
  "presentacion": "50 g",
  "categoria": "Café soluble",
  "disponible": true
}
```

## 4. Especificación técnica de la API

| Operación | Método HTTP | Ruta | Entrada | Respuesta esperada | Código HTTP |
|---|---|---|---|---|---|
| Consultar todos los productos | `GET` | `/api/productos` | No requiere cuerpo | Colección JSON con todos los productos | `200 OK` |
| Consultar producto por ID | `GET` | `/api/productos/{id}` | ID en la URI | Producto solicitado en JSON | `200 OK` |
| Registrar producto | `POST` | `/api/productos` | Producto en JSON | Producto registrado en JSON | `201 Created` |
| Consultar producto inexistente | `GET` | `/api/productos/{id}` | ID inexistente en la URI | Respuesta sin producto | `404 Not Found` |

## 5. Análisis y justificación

### ¿Por qué la ruta utiliza un sustantivo y no una acción?

Las rutas REST representan recursos. Por ello se utiliza el sustantivo plural `productos` en lugar de acciones como `consultarProductos`. La acción se expresa mediante el método HTTP.

### ¿Qué diferencia existe entre una URI de colección y una URI individual?

`/api/productos` representa la colección completa y permite consultarla o agregar un elemento. `/api/productos/{id}` representa un producto específico identificado por el valor incluido en la URI.

### ¿Por qué el método HTTP forma parte del significado de la operación?

Una misma URI puede admitir operaciones diferentes. `GET /api/productos` consulta la colección y `POST /api/productos` registra un producto. El método expresa la intención de la petición.

### ¿Qué información viaja en la URI y cuál en JSON?

La URI identifica el recurso solicitado; por ejemplo, el ID viaja en `/api/productos/3`. Los datos que describen un producto nuevo viajan en el cuerpo de la petición en formato JSON.

### ¿Qué código distingue una consulta exitosa, una creación y un recurso inexistente?

- `200 OK`: la consulta se procesó correctamente.
- `201 Created`: el producto fue registrado correctamente.
- `404 Not Found`: no existe un producto con el identificador solicitado.

## 6. Implementación

`ProductoController` utiliza `@RestController` para procesar peticiones y retornar datos. La ruta base se define con `@RequestMapping("/api/productos")`. Las operaciones usan `@GetMapping` y `@PostMapping`; el ID se recibe con `@PathVariable` y el producto enviado en JSON con `@RequestBody`.

El catálogo inicia con ocho productos ficticios almacenados en una lista en memoria. Spring Web utiliza Jackson para transformar objetos `Producto` en JSON. En una petición `POST`, Jackson transforma el JSON recibido en un objeto Java.

## 7. Ejecución

### IntelliJ IDEA

1. Abrir el proyecto.
2. Esperar la descarga de dependencias de Maven.
3. Ejecutar `Taller1ServiciosWebApplication`.
4. Verificar que el servidor inicie sin errores en el puerto `8080`.

### Terminal

macOS o Linux:

```bash
./mvnw spring-boot:run
```

Windows:

```bat
mvnw.cmd spring-boot:run
```

Dirección base:

```text
http://localhost:8080/api/productos
```

## 8. Ejemplos de peticiones

### Consultar la colección

```http
GET /api/productos
```

Respuesta esperada: `200 OK` y una colección JSON.

### Consultar un producto

```http
GET /api/productos/3
```

Respuesta esperada: `200 OK` y el producto con ID `3`.

### Consultar un producto inexistente

```http
GET /api/productos/999
```

Respuesta esperada: `404 Not Found`.

### Registrar un producto

```http
POST /api/productos
Content-Type: application/json
```

```json
{
  "id": 9,
  "nombre": "Café Clásico",
  "presentacion": "100 g",
  "categoria": "Café soluble",
  "disponible": true
}
```

Respuesta esperada: `201 Created` y el producto registrado.

## 9. Matriz de pruebas con Postman

| # | Objetivo | Método | URL | Entrada | Código esperado | Resultado a verificar |
|---|---|---|---|---|---|---|
| 1 | Consultar la colección | `GET` | `/api/productos` | No aplica | `200 OK` | Retorna los ocho productos iniciales. |
| 2 | Consultar un ID existente | `GET` | `/api/productos/3` | No aplica | `200 OK` | Retorna exactamente el producto con ID `3`. |
| 3 | Consultar el primer ID | `GET` | `/api/productos/1` | No aplica | `200 OK` | Retorna el producto con ID `1`. |
| 4 | Consultar un ID inexistente | `GET` | `/api/productos/999` | No aplica | `404 Not Found` | Comunica que el recurso no existe. |
| 5 | Registrar un producto válido | `POST` | `/api/productos` | Producto en JSON | `201 Created` | Recibe y retorna el producto creado. |
| 6 | Comprobar el registro | `GET` | `/api/productos` | No aplica | `200 OK` | El producto nuevo aparece en la colección. |

> **Pendiente para el integrante 3:** agregar por cada prueba el código y respuesta realmente recibidos, la captura de Postman y una conclusión técnica.

## 10. Arquitectura

Recorrido exitoso de `GET /api/productos/3`:

```text
Postman → HTTP Request → DispatcherServlet → ProductoController
        → productos en memoria → Producto → Jackson → JSON
        → HTTP Response 200 OK → Postman
```

Recorrido de `GET /api/productos/999`:

```text
Postman → HTTP Request → DispatcherServlet → ProductoController
        → búsqueda en memoria → producto no encontrado
        → HTTP Response 404 Not Found → Postman
```

En el recorrido exitoso se encuentra un objeto Java que Jackson transforma en JSON. En el recorrido de error no existe un objeto que transformar y el controlador retorna `404 Not Found`.

> **Pendiente para el integrante 3:** agregar el archivo o enlace del diagrama de draw.io con ambos recorridos.

## 11. Aportes del equipo

### Integrante 1 - Diseño técnico y modelado

**Rama:** `Max`

- Definición del recurso `Producto` y sus atributos.
- Implementación de constructores, getters, setters y `toString()`.
- Participación en la especificación técnica inicial.

### Integrante 2 - Implementación de endpoints

**Rama:** `Fernando`

- Configuración de `ProductoController` con `@RestController`.
- Definición de `/api/productos` y carga de ocho productos en memoria.
- Implementación de `GET /api/productos`.
- Implementación de `GET /api/productos/{id}` con `@PathVariable`.
- Manejo de respuestas `200 OK` y `404 Not Found`.
- Implementación de `POST /api/productos` con `@RequestBody` y `201 Created`.

### Integrante 3 - Pruebas, documentación y arquitectura

**Nombre y rama:** pendiente de completar.

- Ejecución y documentación de pruebas en Postman.
- Registro de resultados y conclusiones técnicas.
- Elaboración del diagrama en draw.io.
- Documentación de los recorridos exitoso y de recurso inexistente.

## 12. Consideraciones

- La aplicación no utiliza base de datos.
- Los datos existen solamente mientras la aplicación está en ejecución.
- Al reiniciar el servidor se recuperan los ocho productos iniciales.
- El proyecto fue creado exclusivamente con fines académicos.
