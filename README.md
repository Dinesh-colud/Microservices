# E-Commerce Microservices

This project is built to learn Microservices architecture using Spring Boot and Spring Cloud.

The application is divided into multiple independent services:

- Product Service
- Inventory Service
- Order Service
- API Gateway
- Eureka Server

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- OpenFeign
- Netflix Eureka
- Spring Cloud Gateway
- Maven

## Features

- Product CRUD
- Inventory CRUD
- Order CRUD
- Service Discovery using Eureka
- API Gateway
- Communication using OpenFeign
- Check stock before placing an order
- Reduce inventory automatically after successful order

## Project Structure

```
discovery-server
api-gateway
product-service
inventory-service
order-service
```

## Future Improvements

- Spring Security + JWT
- Docker
- Config Server
- Kafka
