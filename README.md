# 📚 Bookstore API
This is a simple RESTful API built using **Spring Boot** and **PostgreSQL** for managing a Bookstore. It includes user authentication using JWT, CRUD operations for books, and filtering/search functionality.

## 🛠 Tech Stack
- ✅ **Java 17**
- ✅ **Spring Boot**
- ✅ **Spring Security (JWT)**
- ✅ **PostgreSQL**
- ✅ **JPA (Hibernate)**
- ✅ **Maven**
- ✅ **Postman** (API testing)
- ✅ **Git & GitHub** (version control)

## ✨ Features
- 🔐 User Signup and Login with JWT Authentication  
- 🔒 Protected routes using JWT token  
- 📚 Full CRUD for books: Create, Read, Update, Delete  
- 🔍 Filtering by: Author, Category, Minimum Rating  
- 📝 Search books by title (partial match supported)  
- ❗ Proper error handling with status codes  
- ✅ Input validation for book data

## ⚙️ Setup Instructions

### 📥 Step 1: Clone the Repository
```bash
git clone https://github.com/negidevashish/bookstore-api-zynetic.git
cd bookstore-api-zynetic
```

### 🛠 Step 2: Configure PostgreSQL
Make sure PostgreSQL is installed and running.  
1. Create a new database named `bookstore_db`.  
2. Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bookstore_db
spring.datasource.username=your_postgres_username
spring.datasource.password=your_postgres_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
> ⚠️ Replace `your_postgres_username` and `your_postgres_password` with your actual credentials.

### ▶️ Step 3: Run the Application

#### 💻 Option 1: Run from IDE
- Open the project in IntelliJ / VS Code / Eclipse
- Run `BookstoreApplication.java`

#### 🔧 Option 2: Run via Maven CLI
```bash
./mvnw spring-boot:run
```
If successful, the app will be running at:  
**http://localhost:8080**

## 📚 API Endpoints

### 🔐 Authentication
| Method | Endpoint       | Description         |
|--------|----------------|---------------------|
| POST   | `/auth/signup` | Register a new user |
| POST   | `/auth/login`  | Login and get JWT   |

### 📘 Book Endpoints (JWT Required)
🔐 Add token in headers:  
`Authorization: Bearer <your_token>`

| Method | Endpoint              | Description            |
|--------|-----------------------|------------------------|
| POST   | `/books`              | Create a new book      |
| GET    | `/books`              | Get all books          |
| GET    | `/books/{id}`         | Get book by ID         |
| PUT    | `/books/{id}`         | Update book by ID      |
| DELETE | `/books/{id}`         | Delete book by ID      |
| GET    | `/books/search`       | Search books by fields |

### 🔍 Filtering and Search
| Use Case         | Endpoint Example                        |
|------------------|-----------------------------------------|
| Filter by Author | `/books?author=Jane Austen`             |
| Filter by Category | `/books?category=Fiction`             |
| Filter by Rating | `/books?rating=4.5`                     |
| Search by Title  | `/books/search?title=Alchemist`         |

## 📁 Project Structure
```
src/
├── main/
│   ├── java/com/devashish_book_store/bookstore/
│   │   ├── controller/       # Controllers (Book, Auth)
│   │   ├── model/            # Entity classes
│   │   ├── repository/       # JPA repositories
│   │   ├── service/          # Business logic
│   │   └── security/         # JWT utils & config
│   └── resources/
│       ├── application.properties
│       └── data.sql          # Sample data (if used)
├── BookstoreApplication.java
└── pom.xml
```

## ❗ Error Handling
- `400 Bad Request` – Invalid input  
- `401 Unauthorized` – JWT required / invalid token  
- `404 Not Found` – Book or endpoint not found  
- `500 Internal Server Error` – Something went wrong  

📦 All errors return structured JSON responses.

## 📘 Project Summary
This is a simple, production-ready RESTful API built using **Spring Boot** and **PostgreSQL** for a Bookstore application. It includes secure user authentication with JWT, CRUD operations on books, filtering and search capabilities, and proper error handling.  
The project follows clean code practices, uses standard Spring architecture with services, repositories, and controllers, and is tested using Postman. The database is PostgreSQL, and the code is structured for clarity and maintainability.  
> 🚀 This backend can be used as a base for any full-stack bookstore or library management app.
