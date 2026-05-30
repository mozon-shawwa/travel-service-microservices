# ✈️ Travel Service Microservices Architecture

An advanced, scalable, and resilient Travel Management System built using **Spring Boot Microservices Architecture**.
This project demonstrates modern cloud-native practices, service discovery, centralized routing, database isolation, inter-service communication using gRPC,
and fully automated **CI/CD pipelines**.

---

## 🏗️ Architecture Overview

The system is designed using a **decentralized database-per-service pattern** to ensure loose coupling and independent scalability.

### 🌟 Key Features & Tech Stack
* **Framework:** Spring Boot 3.x & Java 17
* **Service Discovery:** Netflix Eureka Server (Service Registry)
* **API Gateway:** Spring Cloud Gateway (Centralized Routing & Load Balancing)
* **Databases:** MySQL (with independent schemas per service)
* **Inter-Service Communication:** Synchronous gRPC for high-performance internal requests.
* **DevOps & Containerization:** Docker & Docker Compose
* **CI/CD Automation:** GitHub Actions integrated with Docker Hub

---

## 📦 System Components & Microservices

1. **Service Registry (`service-registry`)**: Central hub using Netflix Eureka where all microservices register themselves dynamically.
2. **API Gateway (`cloud-gateway`)**: Entry point for all client requests, routing traffic dynamically to healthy service instances on port `8089`.
3. **Customer Service (`customer-service`)**: Manages customer profiles, authentications, and details.
4. **Flight Service (`flight-service`)**: Handles flight schedules, availability, and routing.
5. **Booking Service (`booking-service`)**: Core orchestration service managing travel bookings.It communicates with `flight-service` and `customer-service` seamlessly via **gRPC**.
7. **Payment Service (`payment-service`)**: Manages transactions, payment verification, and logging.

---

## 🚀 DevOps & CI/CD Bonus Implementation

### 🐳 Containerization (Docker)
The entire ecosystem is fully containerized. A master `docker-compose.yml` file is provided to orchestrate the lifecycle, network connection, and dependencies
between the Spring Boot containers and the MySQL databases.

### 🔄 Automated CI/CD Pipeline (GitHub Actions)
A robust Continuous Integration and Continuous Deployment pipeline is configured inside `.github/workflows/ci-cd.yml`.

**Pipeline Workflow:**
1. Triggers automatically on every `push` to the `main` branch.
2. Compiles and builds the Java application using **Gradle Wrapper**.
3. Authenticates securely with **Docker Hub** using Repository Secrets (`DOCKER_HUB_USERNAME` and `DOCKER_HUB_TOKEN`).
4. Builds the Docker image for the microservices and pushes the production-ready image automatically to Docker Hub.

---

## 🛠️ How to Run the Project Locally

### Prerequisites
* Docker Desktop installed and running.
* Java 17 SDK & Gradle installed (or use `./gradlew`).

### Steps to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/mozon-shawwa/travel-service-microservices.git
   cd travel-service-microservices
Build the Project Jars:

Bash
./gradlew build -x test
Spin up the entire ecosystem using Docker Compose:

Bash
docker-compose up -d --build
Verify the services are running:

Open the Eureka Dashboard at: http://localhost:8761

Ensure all services (GATEWAY, CUSTOMER-SERVICE, FLIGHT-SERVICE, BOOKING-SERVICE, PAYMENT-SERVICE) status is UP.

🔀 API Routing via Gateway (Port 8089)
All API calls must go through the Central Gateway. Examples:

Flight Endpoint:  http://localhost:8089/flights/

Booking Endpoint: http://localhost:8089/bookings/
