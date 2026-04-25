#  Spring Boot Student REST API

A simple and clean **Spring Boot REST API** project for managing student data using **MySQL Database**, **JPA**, and **Validation**.

---

##  Features

- ✅ CRUD Operations (Create, Read, Update, Delete)
- ✅ REST API Architecture
- ✅ Spring Data JPA (Database handling)
- ✅ MySQL Integration
- ✅ DTO Pattern (Clean Code)
- ✅ Validation using Jakarta Validation
- ✅ Layered Architecture (Controller → Service → Repository)

---

## 🛠️ ⚙️ Tech Stack

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- MySQL
- Lombok
- ModelMapper



## 🔗 📡 API Endpoints

| Method | Endpoint | Description |
|------|--------|------------|
| GET | /api/students | Get all students |
| GET | /api/students/{id} | Get student by ID |
| POST | /api/students | Create new student |
| PUT | /api/students/{id} | Update full student |
| PATCH | /api/students/{id} | Partial update |
| DELETE | /api/students/{id} | Delete student |

---

## ⚙️ 🧾 Application Configuration

```properties
spring.application.name=LearningRESTAPIs

spring.datasource.url=jdbc:mysql://localhost:3306/restapi
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


