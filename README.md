# ☀️ Solar Circumference Calculator

A simple fullstack application to calculate the circumference of the sun using Pi and diameter.

This project consists of two parts: 
- `be/` → Backend: Spring Boot + Java 21
- `fe/` → Frontend: Vite + React

---

## 🗂 Folder Structure

├── be/ # Spring Boot (Java 21)

└── fe/ # Vite + React


---

## 📦 Prerequisites

Before you start, make sure you have installed:

- Java 21  
- Node.js (recommended version 18+)  
- PostgreSQL  
- Maven (optional, if you don’t want to use the wrapper `./mvnw`)

---

## 🚀 Installation & Running the Project

### 1. Clone Repository

```bash
git clone https://github.com/ariefw96/naluri-circle.git
cd naluri-circle
```

### 2. Setup Project


Navigate to the backend folder:
```bash
cd be
```
Edit the database configuration file located at src/main/resources/application.properties. Find and update the following lines with your PostgreSQL database credentials:
```bash
spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```
Replace ${DB_HOST}, ${DB_PORT}, ${DB_NAME}, ${DB_USERNAME}, and ${DB_PASSWORD} with your own database values.

Install backend dependencies and build the project:
```bash
./mvnw clean install
```
Or, if you have Maven installed globally:
```bash
mvn clean install
```

Next, go to the frontend folder:
```bash
cd ../fe
```

Install frontend dependencies:

```bash
npm install
```
or if you use Yarn
```bash
yarn install
```

### 3. Running the Project
#### Backend (SpringBoot)

Navigate to backend folder
```bash
cd ../be
```
Run springboot
```bash
./mvnw spring-boot:run
```
or 
```bash
mvn spring-boot:run
```

The backend server will start and listen on port 8080

#### FrontEnd (React)
Next, navigate to frontend folder
```bash
cd ../fe
```
then run the project
```bash
npm run dev
```
The frontend will start and be available at http://localhost:5173.

Voila, now you can access the app and use it to calculate the circumference of the sun!

