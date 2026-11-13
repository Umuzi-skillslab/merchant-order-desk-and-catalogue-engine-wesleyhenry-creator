# PayNest Commerce Kernel

PayNest is a Java-based commerce demo designed for small South African merchants who need a simple way to manage products, customers, orders, and payments in a lightweight application.

The project demonstrates core e-commerce concepts in a clean object-oriented design and serves as a practical example of how an order system can be structured in Java.

## Overview

This application allows a merchant to:

- create and manage products
- create and store customer details
- build an order for a customer
- add products with quantities to the order
- calculate line totals and the grand total
- print a clear order summary
- process payment using different payment methods

The implementation focuses on maintainability and extensibility while keeping the business logic simple and readable.

## Features

### Product management
- store product ID, name, and price
- calculate product totals based on quantity
- keep pricing logic separate from order logic

### Customer management
- create customer accounts with ID, name, and email
- associate customers with orders

### Order management
- create orders for customers
- add products to an order with quantities
- calculate total cost automatically
- print a formatted summary for checkout
- validate that quantity values are greater than zero

### Payment handling
The project includes a payment abstraction and concrete payment methods such as:

- CardPayment
- EFT payment
- Wallet payment
- PayJustNow payment

This makes it easy to extend the checkout flow with new payment options.

### Testing
JUnit 5 tests cover core behavior, including:

- order total calculations
- quantity validation
- service-level order operations
- payment processing logic

## Project structure

src/
├── main/
│   └── java/
│       ├── app/
│       │   └── PayNestApplication.java
│       ├── domain/
│       │   ├── Customer.java
│       │   ├── Order.java
│       │   ├── OrderItem.java
│       │   └── Product.java
│       ├── payment/
│       │   ├── CardPayment.java
│       │   ├── EFTPayment.java
│       │   ├── PayJustNowPayment.java
│       │   ├── PaymentMethod.java
│       │   ├── PaymentProcessor.java
│       │   └── WalletPayment.java
│       └── service/
│           └── OrderService.java
│
└── test/
    └── java/
        ├── domain/
        │   ├── OrderTest.java
        └── service/
            └── OrderServiceTest.java
             └── payment/
            └── PaymentMethodTest.java



## Tech stack

- Java 21
- Maven
- JUnit 5

## Prerequisites

- Java 21 or newer
- Maven installed and available on your PATH

## Getting started

### 1. Clone the repository

## Running the Project

The project uses Java 21 and Maven.

Compile the project:

bash
mvn clean compile


Run all tests:

bash
mvn clean test


Run the demonstration application:

bash
mvn exec:java
Or
mvn exec:java -Dexec.mainClass=app.PayNestApplication


## Expected Demo

The application builds an order containing a laptop, two mice, and five headphones. The order total is R19900. The selected payment method receives that calculated total and processes it through the common `PaymentMethod` interface.


## Example output

Example output:

Order summary
========================
Customer: Wesley Henry
Email: wesleyhenry@umuzi.org
========================
Order ID: 1
Items:
 - Laptop | x1 | R12000
 - Mouse | x2 | R400
 - Headphones | x5 | R7500
========================
Total: R19900
========================
Processing card payment for R19900
Payment successful via CARD
Amount: R19900

## Design notes

### Why `OrderItem` exists
`OrderItem` separates the order into individual line entries so each product can track its own quantity and subtotal independently. This keeps the order model cleaner and easier to extend.

### Why `Order` owns its items
The `Order` class manages the collection of items so totals remain consistent and validation occurs in one place. This is a strong foundation for adding future features such as discounts, VAT logic, and stock management.

### Extensibility
The design keeps pricing and calculation logic tied to domain objects rather than embedding everything in a single class. That makes it easy to add new fields or checkout features without disrupting the core flow.

## Author

Wesley Henry

IMI Java Trainee