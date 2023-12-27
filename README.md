# My Spring Project

My Spring Project is a modularized Spring Boot application with two modules: `app` and `resttemplate`. The application
provides user management functionalities through a RESTful API and includes a client module (`resttemplate`) for
consuming the API.

## Modules

### 1. app

The `app` module contains the core application with the following components:

- **Entities:** Defines the JPA entities (`User` and `Role`) representing the database tables.
- **Mapper:** Maps between DTOs and entities.
- **Repository:** Provides Spring Data JPA repositories for database operations.
- **Service:** Implements the business logic for user management.

### 2. resttemplate

The `resttemplate` module serves as a client for interacting with the user management API provided by the `app` module.
It includes:

- **Client Interface (`UserClient`):** Defines methods for consuming user-related operations.
- **Client Implementation (`UserClientImpl`):** Implements the `UserClient` interface using Spring's `RestTemplate` for
  making RESTful API calls.
- **Configuration (`RestTemplateBuilderConfig`):** Configures the `RestTemplateBuilder` with a root URL for the API.

## Configuration

The application uses Spring Boot and is configured through the `application.yml` file. Key configurations include
database settings, Flyway migration, logging, and JWT configuration.

## Database

The application uses PostgreSQL as the database. Database scripts are provided to create tables (`users`, `roles`,
and `users_roles`) and insert sample data.

## Running the Application

To run the application, use the following command:

```bash
./mvnw spring-boot:run
