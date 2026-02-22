# CloudCart – Order Service Architecture

## 1. Overview

The Order Service is responsible for managing customer orders within the CloudCart distributed system.

It exposes REST APIs to:
- Create new orders
- Retrieve order details
- Track order status

This service is designed following clean layered architecture principles and event-driven communication.

---

## 2. Architectural Style

This service follows:

- Layered Architecture
- Domain-Driven Separation
- Event-Driven Communication
- Stateless Microservice Design

The service communicates asynchronously with other services (e.g., Inventory Service) using Apache Kafka.

---

## 3. High-Level Flow

Client → API Gateway → Order Service → Kafka → Inventory Service

1. Client submits order request
2. Order Service validates and persists order
3. Order Service publishes `OrderCreatedEvent` to Kafka
4. Inventory Service consumes event and reserves stock
5. Order status is updated asynchronously

The system is eventually consistent.

---

## 4. Package Structure

com.cloudcart.order

- controller → REST endpoints
- service → Business logic
- repository → Database access
- domain → JPA entities
- dto → Request and response models
- event → Kafka producers
- exception → Error handling
- config → Configuration classes

Strict separation of concerns is enforced.

---

## 5. Data Management

- Database: PostgreSQL
- ORM: Spring Data JPA
- Transactions handled at service layer

Entities are never exposed directly to external clients.
DTOs are used for API contracts.

---

## 6. Event-Driven Communication

Apache Kafka is used for asynchronous communication.

Events:
- OrderCreatedEvent
- OrderStatusUpdatedEvent (future)

Design considerations:
- Idempotency support
- Retry policies
- Dead-letter topic strategy
- Event versioning support

---

## 7. Scalability Strategy

This service is designed to be:

- Stateless
- Horizontally scalable
- Kubernetes-ready

Future scaling considerations:
- Horizontal Pod Autoscaler (HPA)
- Resource limits
- Liveness and readiness probes
- Rate limiting at gateway level
- Redis caching integration

---

## 8. Resilience Strategy (Planned)

- Retry mechanism for Kafka publishing
- Circuit breaker (Resilience4j)
- Graceful error handling
- Centralized logging
- Structured JSON logs

---

## 9. Testing Strategy

Goal: Minimum 80% line coverage.

Testing layers:
- Unit tests (service layer)
- Controller tests
- Integration tests with Testcontainers
- Kafka integration tests (future phase)

JaCoCo is used for coverage enforcement.

---

## 10. Observability (Planned)

- Micrometer metrics
- Prometheus integration
- Distributed tracing (future)
- Structured logging

---

## 11. Cloud Strategy

Phase 1:
- Local Docker deployment

Phase 2:
- Kubernetes deployment (local cluster)

Phase 3:
- AWS EKS deployment
- Infrastructure as Code (future)

---

## 12. Design Principles

- Clean code
- SOLID principles
- Separation of concerns
- Fail fast validation
- Explicit error handling
- No business logic in controllers
- No DTO leakage into persistence layer

---

## 13. Future Enhancements

- JWT authentication
- Idempotency keys
- Event schema registry
- API versioning
- Rate limiting
- Redis integration
- CI/CD pipeline
- Helm charts

---

## Conclusion

The Order Service is designed as a production-grade, cloud-native microservice emphasizing scalability, maintainability, and resilience.

It serves as the foundation for a distributed, high-traffic, event-driven commerce platform.