# Introduction 
Welcome to my project, a robust boca instance system built on Spring Boot 3 and powered by Docker containerization.

# Getting Started

Welcome to the Boca integration System powered by Spring Boot 3 and Docker. This guide will walk you through the steps to set up and run the application efficiently.

Prerequisites

Before you begin, ensure that you have the following technologies installed on your system:

### Java Development Kit (JDK): 
You need Java 17 or later installed. You can download it from the official Oracle website or use an OpenJDK distribution.

### Maven: 
Maven is used for building and managing the project. You can download it from the official Apache Maven website and follow the installation instructions.

### Docker: 
To run the application within a Docker container, you must have Docker installed. You can download Docker for your specific platform from the Docker website.

# Build and Test

### Clone the Repository

```kotlin
git clone https://github.com/Borgarelli/BocaProject.git
```

### Build the Docker-Compose on Terminal:
```kotlin
docker-compose up -d
```

### Build the Project:
```kotlin
mvn clean install
```

### Start the Application:
```kotlin
mvn spring-boot:run
```

### Run the Tests
```kotlin
mvn clean test
```

# Postman Collections for testing Project
You can download the Postman Collections here
[Boca Rest Api.postman_collection.json](https://github.com/user-attachments/files/15921232/Boca.Rest.Api.postman_collection.json)

## Important!
Is necessary change the file you be sending on Solution Endpoint Post, to a local mergulho.py or zerinhoouum.py on main of Boca Project.
