# Description
- REST API service for products data

# Technologies
- Java
- Spring Boot
- Spring Security (basic authentication)
- Spring Data JPA
- H2 on memory database
- Flyway
- Spring Test
- Docker

# Build and Run
Application is based on spring boot which means it is autonomous and self contained as it contains all required dependencies and configurations.

To build and run, after you pull the application, follow one of the following approaches :

1- Build and run using spring boot plugin
- $ mvn spring-boot:run

2- Build and run the generated jar
- mvn package
- java -jar target/products-service-0.0.1-SNAPSHOT.jar

3- Using docker
- mvn package
- docker build -t products-service .
- docker run  -p 8080:8080 products-service

# Testing
You need to provide username and password, as configured (username: user
/ password: password)

1- Using CURL
- curl -u user:password -X GET -i "http://localhost:8080/api/products"
- curl -u user:password -X GET -i "http://localhost:8080/api/products/1"
- curl -u user:password -X PUT "http://localhost:8080/api/products/1" -H "Content-Type: application/json" -d "{ \"id\": 1, \"name\": \"test\", \"currentPrice\": 74.99, \"lastUpdate\": null, \"description\": \"new description\"}"
- curl -u user:password -X POST "http://localhost:8080/api/products" -H "Content-Type: application/json" -d "{ \"currentPrice\": 9, \"description\": \"product description\", \"name\": \"product-name\"}"

2- Using swagger (excluded from security validation, you do not have to provide username/password)
- http://localhost:8080/swagger-ui.html

# Notes/Limitations
- it will be better if we have flyway scripts for each environment.
- I used in memory database for simplicity
- last update is implemented on entity and it will be better if we have
  created date to be implemented as well
