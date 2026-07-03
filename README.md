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


▶️ How to Run / Execute the Project

This project focuses on backend persistence and ORM concepts using JPA (Hibernate).
It does not include a UI or REST API layer.

Prerequisites
Java 8+
Maven
MySQL
JPA (Hibernate)


Steps to Execute
----------------

1️⃣ Clone the Repository

git clone https://github.com/Venkata-Kishor-Polakattu/ticketplus.git
cd cinema-ticket-booking-system


2️⃣ Create the Database
CREATE DATABASE cinema_db;


3️⃣ Configure Database Connection
Update the database details in:

src/main/resources/META-INF/persistence.xml

<property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/cinema_db"/>
<property name="jakarta.persistence.jdbc.user" value="root"/>
<property name="jakarta.persistence.jdbc.password" value="password"/>


4️⃣ Build the Project
mvn clean install


5️⃣ Run Persistence Operations
The project is executed by invoking DAO / Service layer methods to perform:
Movie creation
Show scheduling
Ticket booking
Database persistence and retrieval
Execution can be done via:
A main test class, or
JUnit test cases, or
Manual method invocation for learning and testing purposes



**Note**:
This project is designed to demonstrate JPA/Hibernate backend concepts.
UI and REST API layers can be added in future versions.
