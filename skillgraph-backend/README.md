# SkillGraph - DSA & Placement Readiness Tracker 🎯

SkillGraph is a backend-powered platform designed to help students track their coding practice, analyze progress, and stay placement-ready with structured data and feedback.

---

## ✅ Features Implemented (Day 1)
- 📦 Spring Boot Project Setup (Maven)
- 🗂️ Organized Folder Structure (Controller, DTO, Service, Config, Repository, Model)
- 🧩 PostgreSQL Database Integration
- 🔐 Password Encoder Bean (BCrypt)
- 🧾 `POST /users/register` – User registration API
- ✅ Username & email uniqueness checks
- 📫 Email & password input supported

---

## 🚧 Pending Tasks
- ⚠️ Fix validation issues (`@Valid`, `@Email`)
- 🔐 Add Spring Security or JWT (for authentication)
- 📥 Complete Login API (POST `/users/login`)
- 📬 Error handling & validation responses
- 🧪 Postman Collection + API Documentation

---

## 🔧 Tech Stack
- Java 17
- Spring Boot
- PostgreSQL
- Maven
- IntelliJ IDEA

---

## 💻 Local Setup

```bash
git clone https://github.com/anjali0614/skillgraph.git
cd skillgraph
./mvnw spring-boot:run
