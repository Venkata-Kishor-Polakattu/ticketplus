# ticketplus 
A console-based Java mini project built using Hibernate ORM, designed to demonstrate real-world workflows like movie management, show scheduling, seat booking, payments, cancellations, and unit testing.
This project was developed as a fresher-level learning project to understand Hibernate, ORM concepts, and database-driven application design.

📘 Overview

This application supports:

👨‍💼 Admin

Add movies

Create auditoriums

Schedule shows

👤 Customer

View seat availability

Book seats

Confirm payment

Cancel bookings

🛠️ Technologies Used

Java 8+

Hibernate ORM

MySQL Database

JPA Annotations

JUnit (Unit Testing)

Maven (if used)

🧠 Hibernate Features Implemented

Entity mapping using JPA annotations

One-to-Many, Many-to-One, One-to-One relationships

Lazy & Eager loading

HQL queries and Criteria API

Transaction management

Optimistic locking using @Version

Soft deletes (status-based)

First-level & Second-level caching

Auto timestamps using @CreationTimestamp and @UpdateTimestamp

🧪 Unit Testing (JUnit)

The project includes JUnit test cases for:

Movie Service

Booking Service

Payment Service

Show Scheduling Logic

Seat Availability Logic

These tests help verify:

CRUD operations

Booking validations

Non-overlapping show timings

Transaction safety

Payment updates

🧩 Core Modules
1️⃣ Movies & Shows Management

Add new movies

Create auditoriums

Schedule shows (prevents overlapping timings)

2️⃣ Seat Booking

View available/booked seats

Book multiple seats in one transaction

Rollback on failure to ensure atomicity

3️⃣ Payment & Cancellation

Simulate payment (Cash / Card / UPI)

Confirm booking

Cancel booking (only before show time)

Free up seats & mark refund status

📁 Project Structure
src/
 ├── entity/
 │    ├── Movie.java
 │    ├── Auditorium.java
 │    ├── Seat.java
 │    ├── Show.java
 │    ├── ShowSeat.java
 │    ├── Booking.java
 │    ├── BookingItem.java
 │    └── Payment.java
 │
 ├── dao/
 │    ├── MovieDAO.java
 │    ├── ShowDAO.java
 │    ├── SeatDAO.java
 │    ├── BookingDAO.java
 │    └── PaymentDAO.java
 │
 ├── service/
 │    ├── MovieService.java
 │    ├── BookingService.java
 │    └── PaymentService.java
 │
 ├── test/
 │    ├── MovieServiceTest.java
 │    ├── BookingServiceTest.java
 │    └── PaymentServiceTest.java
 │
 ├── config/
 │    └── HibernateUtil.java
 │
 └── Main.java

🖥️ Console Menu Flow
Main Menu
1. Admin
2. Customer
3. Exit

Admin Menu
1. Add Movie
2. Create Show
3. Create Auditorium
4. Exit

Customer Menu
1. View Seats
2. Book Tickets
3. Confirm Payment
4. Cancel Booking
5. Exit

🎯 Learning Outcomes

From this project, I learned:

Hibernate ORM fundamentals

Designing entity relationships

Using HQL & Criteria API

Handling transactions & rollbacks

Implementing real booking workflows

Writing unit tests with JUnit

Building structured console applications
