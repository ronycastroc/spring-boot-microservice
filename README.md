# User Registration Microservice

This project is a user registration microservice developed in Java using the Spring Boot framework. The goal is to provide a basic structure for creating, updating, retrieving, and deleting users in a system.

### Technologies Used

- Java
- Spring Boot
- Maven
- Spring Data JPA
- Spring Web
- H2 Database (in development environment)
- Lombok
- Spring Boot DevTools
- Spring Boot Starter Validation
- Spring Security Crypto

### Running the Project
1. Clone the repository:
```bash
git clone git@github.com:ronycastroc/spring-boot-microservice.git
```

2. Navigate to the project directory:
```bash
cd spring-boot-microservice
```

3. Run the project using Maven:
```bash
./mvnw spring-boot:run
```

4. The application will be available at `http://localhost:8080`.

### Additional Configurations
- This project uses the H2 database in the development environment. You can access the H2 console at http://localhost:8080/h2-console. Database configurations are available in the application.properties file.
- Make sure to adjust settings such as the database URL, username, and password as needed for your production environment.
