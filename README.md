# W2-Group4 Project

## Session Overview

### Session 1: Introduction and IDE Setup

- **Objective:** Introduce the Integrated Development Environment (IDE) and guide participants in setting it up.
- **Tools Used:** IntelliJ IDEA, Eclipse, or Visual Studio Code.
  
#### Installation Instructions:
1. **Download IDE:**
   - Go to the official website of your chosen IDE.
   - Select the version compatible with your operating system.

2. **Install IDE:**
   - Follow the installation instructions provided on the website.
   - Ensure to allow any necessary permissions during the installation process.

3. **Configure Required Plugins:**
   - After installation, open the IDE.
   - Navigate to the plugin settings and install essential plugins for the project (e.g., Lombok for Java, or specific extensions for JavaScript).

---

### Session 2: Project Setup

- **Objective:** Set up the project with an organized directory structure and install the necessary libraries.
  
#### Steps to Follow:
1. **Create a New Project:**
   - Open the IDE and select "Create New Project."
   - Choose the appropriate project type (Java, Spring, etc.).

2. **Establish Directory Structure:**
   - Create directories for `src`, `main`, `resources`, and `test` folders to organize your code.

3. **Install Dependencies:**
   - Use Maven or Gradle to add necessary libraries to your project. Ensure to add dependencies like Spring Boot, JPA, or any other relevant libraries.

    Example `pom.xml` snippet for Maven:
     ```xml
     <dependencies>
         <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-data-jpa</artifactId>
         </dependency>
         <dependency>
             <groupId>com.h2database</groupId>
             <artifactId>h2</artifactId>
             <scope>runtime</scope>
         </dependency>
     </dependencies>


### Session 3: Understanding H2 Database and JDA (Java Database Access)

#### Documentation Section: Using H2 and JDA

## Overview
This section describes how to utilize **H2 Database** and **Java Database Access (JDA)** in our Spring Boot application. These technologies provide a lightweight, in-memory database solution for development and testing, facilitating rapid application development and efficient data management.

## Technologies Used
1. **H2 Database**
   - **Description**: H2 is an open-source, lightweight, in-memory SQL database ideal for development, testing, and prototyping. It allows developers to run a database without the need for a separate server installation, making it highly suitable for applications where simplicity and speed are essential.
   - **Use Cases**:
     - Quick prototyping of database-driven applications.
     - Unit testing with a database that resets after each test run.
     - Development environments that require fast database access without the overhead of a full database server.

2. **Java Database Access (JDA)**
   - **Description**: JDA is a framework that simplifies the interaction between Java applications and databases using JPA (Java Persistence API). It provides a set of annotations and interfaces to manage data persistence, enabling developers to perform CRUD operations easily.
   - **Use Cases**:
     - Mapping Java objects to database tables.
     - Executing queries and managing transactions through repository interfaces.
     - Simplifying database operations with built-in methods provided by JPA, such as `save()`, `findAll()`, and `deleteById()`.

## Implementation Details

**H2 Configuration**:
The H2 database is configured in the `application.properties` file, enabling the H2 console for easy access during development. The in-memory database is created and managed automatically, allowing for rapid iteration without persistent data storage.

    ```java
    spring.application.name=session3
    
    spring.datasource.url=jdbc:h2:mem:database
    spring.datasource.driver-class-name=org.h2.Driver
    spring.datasource.username=admin
    spring.datasource.password=admin
    
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
    spring.jpa.hibernate.ddl-auto=update
    spring.h2.console.enabled=true
    spring.h2.console.path=/h2


## JPA Entity Example

The `Product` class serves as a JPA entity, representing a product in the database. It is annotated with `@Entity` and `@Table`, and its fields are mapped to the corresponding columns in the database.

    ```java
    package team5.session3.model;
    
    import jakarta.persistence.*;
    import lombok.*;
    
    @Entity
    @Table(name = "Products")
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    @ToString
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String description;
        private int price;
        private String image;
        private String category;
        private int priceDiscount;
        private int quantity;
        private String unit;
    }


## Repository Interface

The `ProductRepo` interface extends `JpaRepository`, allowing seamless integration with JPA to perform standard database operations on `Product` entities without the need for boilerplate code.

    ```java
    package team5.session3.repository;
    
    import org.springframework.data.jpa.repository.JpaRepository;
    import team5.session3.model.Product;
    
    public interface ProductRepo extends JpaRepository<Product, Long> {
        // Custom query methods can be defined here if needed
    }
    
    ## Controller Class Example
    
    The `ProductController` class handles HTTP requests for managing products. It uses the `ProductRepo` interface to perform CRUD operations.
    
    ```java
    package team5.session3.controller;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import team5.session3.model.Product;
    import team5.session3.repository.ProductRepo;
    
    import java.util.List;
    
    @RestController
    public class ProductController {
        private final ProductRepo productRepo;
    
        @Autowired
        public ProductController(ProductRepo productRepo) {
            this.productRepo = productRepo;
        }
    
        // GET all products
        @GetMapping("/getProductList")
        public ResponseEntity<List<Product>> getAllProduct() {
            List<Product> productList = productRepo.findAll();
            return productList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(productList);
        }
    
        // Additional CRUD methods can be added here
    }


## Using the H2 Console

To interact with the H2 database, you can access the H2 console at [http://localhost:8080/h2](http://localhost:8080/h2). Use the following connection settings:

- **JDBC URL**: `jdbc:h2:mem:database`
- **Username**: `admin`
- **Password**: `admin`

## Conclusion

Using H2 and JDA together in our Spring Boot application provides a robust and efficient way to manage data. H2's lightweight nature makes it perfect for development and testing, while JDA simplifies the interaction with the database through powerful annotations and repository patterns. This combination enables rapid application development while maintaining a clean and maintainable codebase.



