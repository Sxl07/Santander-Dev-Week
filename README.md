# Santander-Dev-Week

API REST desarrollada con Java y Spring Boot durante la Santander Dev Week.

## Tecnologías

- Java 25
- Spring Boot
- Spring Data JPA
- Gradle
- H2 Database (perfil dev)

## Estado actual del proyecto

Actualmente el proyecto ya cuenta con:

- Modelo de dominio base: `User`, `Account`, `Card`, `Feature` y `New`.
- Repositorio `UserRepository` con Spring Data JPA.
- Servicio `UserService` y su implementación `UserServiceImpl`.
- Controlador REST `UserController` con endpoints para consultar y crear usuarios.
- Manejo global de excepciones con `GlobalExceptionHandler`.
- Test de carga de contexto con Spring Boot.

## Endpoints disponibles

- `GET /users/{id}`
  - Busca un usuario por id.
  - Respuesta `200 OK` si existe.
  - Respuesta `404 Not Found` si no existe.

- `POST /users`
  - Crea un usuario nuevo.
  - Respuesta `201 Created` con header `Location`.
  - Respuesta `422 Unprocessable Entity` si ya existe el número de cuenta.

## Manejo global de excepciones

Se implementó un `@RestControllerAdvice` que centraliza errores HTTP:

- `IllegalArgumentException` -> `422 Unprocessable Entity`
- `NoSuchElementException` -> `404 Not Found`
- `Throwable` -> `500 Internal Server Error`

## Configuración de desarrollo (H2)

Archivo: `src/main/resources/application-dev.yml`

- Base en memoria: `jdbc:h2:mem:sdw2023`
- Consola H2 habilitada: `/h2-console`
- `spring.jpa.hibernate.ddl-auto=create`

## Cómo ejecutar

En la raíz del proyecto:

```bash
./gradlew bootRun
```

En Windows (PowerShell):

```powershell
.\gradlew.bat bootRun
```

Para usar el perfil dev:

```powershell
$env:SPRING_PROFILES_ACTIVE="dev"
.\gradlew.bat bootRun
```

## Pruebas

Ejecutar tests:

```bash
./gradlew test
```

En Windows (PowerShell):

```powershell
.\gradlew.bat test
```
