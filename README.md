Here’s a **README** that covers both how to run the Spring Boot To-Do app in **Spring Tool Suite (STS)** and how to use **Docker** to run the application.

---

# To-Do List Application (Spring Boot)

This project implements a RESTful API backend for a To-Do List application using **Spring Boot** and **MySQL**. It can be run either by importing into **Spring Tool Suite (STS)** or by using **Docker**.

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Running in Spring Tool Suite (STS)](#running-in-sts)
3. [Running with Docker](#running-with-docker)
4. [API Endpoints](#api-endpoints)

---

## Prerequisites

Before running the project, ensure the following software is installed on your machine:

- **JDK 17 or later** (if running in STS)
- **Maven** (if running in STS)
- **Spring Tool Suite (STS)** (or any IDE with Spring Boot support)
- **Docker** and **Docker Compose** (if running with Docker)

---

## Running in STS

### 1. Clone the Repository
extractr the repository to your local machine.



### 2. Import the Project into STS

1. Open **Spring Tool Suite (STS)**.
2. Click on `File -> Import...`.
3. Select `Maven -> Existing Maven Projects` and click **Next**.
4. Browse to the cloned project directory, select the root folder, and click **Finish**.

### 3. Update Maven Dependencies

Right-click on the project in the STS project explorer and select:

- `Maven -> Update Project...`

This ensures all dependencies are up-to-date.

### 4. Configure the Database

- By default, the app is configured to use an in-memory **H2** database.
- If you want to use **MySQL**, modify the `src/main/resources/application.properties` file with your MySQL database configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todoappdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

Ensure MySQL is running locally and you have the `todoappdb` database created.

### 5. Run the Application

1. Right-click on the project.
2. Select `Run As -> Spring Boot App`.

This will start the application, and it will be accessible at `http://localhost:8080`.

---

## Running with Docker

### 1. Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/yourusername/todo-app-backend.git
```

### 2. Build the JAR (optional)

If you don't have a pre-built JAR in the `target/` directory, you can generate it using **Maven**:

```bash
mvn clean package
```

This will create `todoappbackend-0.0.1-SNAPSHOT.jar` in the `target/` directory.

### 3. Docker Setup

The application is fully containerized using **Docker** and **Docker Compose**. This setup includes:

- **Spring Boot application** (`todoapp-backend`)
- **MySQL database** (`todoapp-mysql`)

### 4. Docker Compose File

Ensure your `docker-compose.yml` file is configured like this:

```yaml
version: '3.8'

services:
  db:
    image: mysql:8.0
    container_name: todoapp-mysql
    environment:
      MYSQL_ROOT_PASSWORD: yourpassword
      MYSQL_DATABASE: todoappdb
    ports:
      - "3306:3306"
    volumes:
      - mysql-data:/var/lib/mysql

  app:
    build:
      context: .
    container_name: todoapp-backend
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/todoappdb
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: yourpassword
      SPRING_JPA_HIBERNATE_DDL_AUTO: update

volumes:
  mysql-data:
```

Make sure the environment variables, especially for MySQL, are set up correctly.

### 5. Build and Run the Containers

Navigate to the project directory and run:

```bash
docker-compose up --build
```

This will build the Docker image for the backend and start the MySQL database container. 

### 6. Access the Application

Once the containers are running, access the application at:

```url
http://localhost:8080
```

### 7. Stopping the Application

To stop the Docker containers, use:

```bash
docker-compose down
```

---

## API Endpoints

Here are the API endpoints provided by the backend:

- **GET /users/{username}/todos**: Retrieve all todos for a specific user.
- **GET /users/{username}/todos/{id}**: Retrieve a single todo by its ID.
- **POST /users/{username}/todos**: Create a new todo.
- **PUT /users/{username}/todos/{id}**: Update a todo.
- **DELETE /users/{username}/todos/{id}**: Delete a todo by its ID.

---

## Security and CORS

- **CORS (Cross-Origin Resource Sharing)** is enabled to allow interaction between the frontend and the backend.
- The application is secured using **JWT (JSON Web Tokens)** for authentication.

---

This should guide you through running the backend both in STS and Docker. Let me know if you need any more information!