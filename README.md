# 🎬 Cinema Ticket Booking System

A Java-based **Cinema Ticket Booking System** developed using **JPA (Hibernate)** and **MySQL** to manage movies, shows, and ticket bookings with proper entity relationships and database persistence.

---

## 📌 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [System Design](#system-design)
- [Entity Relationships](#entity-relationships)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [How to Run](#how-to-run)
- [Sample Workflow](#sample-workflow)
- [Key Concepts Implemented](#key-concepts-implemented)
- [Future Enhancements](#future-enhancements)
- [Author](#author)
- [License](#license)

---

## 🧾 Overview

The **Cinema Ticket Booking System** is a backend-focused Java application that allows management of movies, scheduling of shows, and booking of cinema tickets.  
It uses **JPA (Hibernate)** for ORM and **MySQL** for persistent data storage.

This project demonstrates strong understanding of:
- Object-Oriented Programming
- JPA entity mapping
- Bidirectional relationships
- Database design
- Clean layered architecture

---

## ✨ Features

- 🎥 Add and manage movies
- ⏰ Schedule multiple shows for a movie
- 🎟️ Book tickets for a selected show
- 🪑 Manage seat availability per show
- 🔗 One-to-Many and Many-to-One entity relationships
- 📊 Enum-based movie status handling
- 💾 Persistent storage using Hibernate & MySQL

---

## 🛠️ Tech Stack

| Category       | Technology |
|---------------|------------|
| Language       | Java |
| ORM            | JPA (Hibernate) |
| Database       | MySQL |
| Build Tool     | Maven |
| Architecture   | Layered Architecture |
| Persistence   | `jakarta.persistence` |

---

## 🧠 System Design

The system follows a **layered architecture**:

- **Entity Layer** – JPA entity classes
- **DAO Layer** – Database operations
- **Service Layer** – Business logic
- **Utility Layer** – EntityManager & persistence handling

---

## 🔗 Entity Relationships

- **Movie → Show** : One-to-Many  
- **Show → Movie** : Many-to-One  
- **Show → Booking** : One-to-Many  

Each movie can have multiple shows, and each show belongs to exactly one movie.

---

## 🗂️ Project Structure

```text
src/main/java
└── com.nk
    ├── beans
    │   ├── Movie.java
    │   ├── Show.java
    │   ├── Booking.java
    │   └── BaseEntity.java
    ├── enums
    │   └── MovieStatus.java
    ├── dao
    │   ├── MovieDao.java
    │   ├── ShowDao.java
    │   └── BookingDao.java
    ├── service
    │   └── BookingService.java
    └── util
        └── JPAUtil.java

src/main/resources
└── META-INF
    └── persistence.xml
