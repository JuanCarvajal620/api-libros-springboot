# API Libros

API REST desarrollada con Spring Boot para la gestión de libros.

## Tecnologías utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- Oracle XE
- Maven
- Swagger / OpenAPI
- Validation API
- ResponseEntity
- DTOs
- Mapper
- Global Exception Handler

---

## Funcionalidades

- Crear libros
- Consultar todos los libros
- Consultar un libro por ID
- Consultar libros por autor
- Actualizar libros
- Eliminar libros
- Validación de datos
- Manejo global de excepciones
- Documentación automática mediante Swagger

---

## Arquitectura

```text
Cliente
↓
Controller
↓
Service
↓
Mapper
↓
Repository
↓
Oracle Database
```

### Componentes principales

- Controller: expone los endpoints REST.
- Service: contiene la lógica de negocio.
- Mapper: convierte entre DTO y Entity.
- Repository: acceso a datos mediante Spring Data JPA.
- DTO: objetos utilizados para la comunicación con la API.
- Entity: representación de la tabla en la base de datos.
- Exception Handler: manejo centralizado de errores.

---

## Configuración de Oracle

1. Conectarse a Oracle con un usuario administrador (por ejemplo `SYSTEM`).

2. Ejecutar el archivo:

```text
database/setup.sql
```

3. Configurar las credenciales en:

```properties
spring.datasource.username=LIBROS
spring.datasource.password=TU_PASSWORD
```

---

## Configuración de application.properties

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XEPDB1

spring.datasource.username=LIBROS

spring.datasource.password=TU_PASSWORD

spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true
```

---

## Endpoints

### Obtener todos los libros

```http
GET /buscar
```

### Obtener un libro por ID

```http
GET /libros/{id}
```

### Obtener libros por autor

```http
GET /libros?autor=Tolkien
```

### Crear libro

```http
POST /libros
```

Body:

```json
{
  "titulo": "El Hobbit",
  "autor": "J.R.R. Tolkien",
  "paginas": 300
}
```

Respuesta:

```http
201 Created
```

### Actualizar libro

```http
PUT /libros/{id}
```

Body:

```json
{
  "titulo": "El Hobbit",
  "autor": "J.R.R. Tolkien",
  "paginas": 320
}
```

Respuesta:

```http
200 OK
```

### Eliminar libro

```http
DELETE /libros/{id}
```

Respuesta:

```http
200 OK
```

---

## Validaciones implementadas

### Título obligatorio

```java
@NotBlank(message = "El titulo es obligatorio")
```

### Autor obligatorio

```java
@NotBlank(message = "El autor es obligatorio")
```

### Páginas mayores a cero

```java
@Positive(message = "Las paginas deben ser mayores a cero")
```

---

## Manejo de errores

### Libro no encontrado

```json
{
  "mensaje": "Libro no encontrado"
}
```

### Error de validación

```json
{
  "mensaje": "El titulo es obligatorio"
}
```

---

## Swagger

Una vez iniciada la aplicación:

```text
http://localhost:8080/swagger-ui/index.html
```

Swagger permite:

- Visualizar todos los endpoints.
- Probar peticiones directamente desde el navegador.
- Consultar DTOs y modelos.
- Revisar respuestas y códigos HTTP.

---

## Clonar el proyecto

```bash
git clone URL_DEL_REPOSITORIO
```

Entrar al directorio:

```bash
cd api-libros-springboot
```

---

## Ejecutar el proyecto

Compilar:

```bash
mvn clean install
```

Ejecutar:

```bash
mvn spring-boot:run
```

---

## Autor

Proyecto desarrollado como práctica de:

- Spring Boot
- Spring Data JPA
- Oracle XE
- APIs REST
- Validaciones
- Swagger / OpenAPI
- Arquitectura por capas
- Buenas prácticas de desarrollo backend