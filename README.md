# W2-Group4 Project

## Introduction

The W2-Group4 project is part of a programming course aimed at developing coding skills and teamwork. Throughout this project, we will engage in three main sessions to establish a solid foundation.

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

- **Objective:** Gain a comprehensive understanding of H2 Database and Java Database Access (JDA), focusing on their roles in developing applications with database functionalities.

#### Key Topics Covered:

1. **Overview of H2 Database:**
   - H2 is a Java-based SQL database that supports in-memory and persistent storage. It’s fast, reliable, and ideal for development purposes, making it suitable for testing and prototyping.

2. **Installation:**
   - Download the H2 Database from the official [H2 Database website](http://www.h2database.com/).
   - Follow the installation instructions based on your operating system. H2 can also be included as a dependency in your Maven or Gradle project.

3. **Configuring the Database:**
   - Add the H2 dependency to your project as shown in Session 2.
   - In your `application.properties` file, configure the database connection:

   ```properties
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
