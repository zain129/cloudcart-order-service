# CloudCart – Order Service

CloudCart Order Service is a cloud-native, event-driven microservice responsible for managing customer orders in a distributed e-commerce system.

This service is part of the larger CloudCart platform, designed to simulate high-traffic, production-grade backend architecture using modern cloud and microservice principles.

---

## 🚀 Tech Stack

- Java 25
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Apache Kafka
- Redis (planned)
- JUnit 5
- Mockito
- Testcontainers
- JaCoCo (code coverage)
- Docker
- Kubernetes (K8s-first strategy)

---

## 🏗️ Architecture Overview

This service follows:

- Clean layered architecture
- Domain separation
- Event-driven communication
- Stateless microservice design

High-level flow:

Client → API Gateway → Order Service → Kafka → Inventory Service

The system is eventually consistent and designed for horizontal scalability.

For detailed architecture explanation, see `architecture.md`.

---

## 📦 Responsibilities

The Order Service is responsible for:

- Creating new orders
- Persisting order data
- Publishing order events to Kafka
- Managing order state transitions
- Providing order query APIs

---

## 📂 Project Structure
com.cloudcart.order
<br>├── controller
<br>├── service
<br>├── repository
<br>├── domain
<br>├── dto
<br>├── event
<br>├── exception
<br>├── config
<br><br>
Strict separation of concerns is enforced.

- Controllers contain no business logic.
- Services contain core business rules.
- Entities are never exposed outside the service layer.
- DTOs are used for API contracts.

---

## 🧪 Testing Strategy

Testing is treated as a first-class concern.

Coverage goal: **80%+ line coverage**

Test layers:
- Unit tests (service layer)
- Controller tests
- Integration tests (Testcontainers)
- Kafka integration tests (planned)

JaCoCo is configured to enforce coverage thresholds.

To run tests:

```bash
mvn clean test
