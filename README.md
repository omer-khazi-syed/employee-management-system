# Employee Management System

A Spring Boot REST API project for managing Employees and Departments.

## Features

- User Registration
- User Login (JWT Authentication)
- Employee CRUD Operations
- Department CRUD Operations
- Spring Security
- JWT Authentication
- MySQL Database
- REST APIs
- Swagger UI
- ModelMapper
- Exception Handling

## Tech Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT
- MySQL
- Maven
- Swagger OpenAPI

## Project Structure

```
src
 ├── controller
 ├── dto
 ├── entity
 ├── repository
 ├── security
 ├── service
 ├── service/impl
 ├── exception
 └── resources
```

## API Endpoints

### User

- POST /api/users/register
- POST /api/users/login

### Department

- POST /api/departments
- GET /api/departments
- GET /api/departments/{id}
- PUT /api/departments/{id}
- DELETE /api/departments/{id}

### Employee

- POST /api/employees
- GET /api/employees
- GET /api/employees/{id}
- PUT /api/employees/{id}
- DELETE /api/employees/{id}

## API Documentation

Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

## Database

MySQL

## Author

**Omer Khazi Syed**

GitHub:
https://github.com/omer-khazi-syed
