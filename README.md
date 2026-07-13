# PayNest Commerce Kernel

## Overview

PayNest is a lightweight commerce system designed for small South African merchants selling products online and at local markets. This application provides a simple order management flow that allows merchants to:

- Manage products and customers
- Create orders
- Add products to orders
- Calculate order totals
- Generate a human-readable order summary

The project is implemented using plain Java and follows object-oriented design principles to ensure maintainability and future extensibility.

---

## Features

### Product Management
- Create products with:
  - ID
  - Name
  - Price (Rand)

### Customer Management
- Create customers with:
  - ID
  - Name
  - Email Address

### Order Management
- Create orders for customers
- Add products and quantities to orders
- Calculate line item totals
- Calculate order grand totals
- Print order summaries

### Validation
- Prevent invalid quantities
- Quantities must be greater than zero

### Testing
JUnit 5 tests included for:
- Order total calculation
- Quantity validation
- Order service functionality

---

## Project Structure

```text
src
├── main
│   └── java
│       ├── app
│       │   └── PayNestApplication.java
│       ├── domain
│       │   ├── Customer.java
│       │   ├── Order.java
│       │   ├── OrderItem.java
│       │   └── Product.java
│       └── service
│           └── OrderService.java
│
└── test
    └── java
        ├── domain
        │   ├── OrderItemValidationTest.java
        │   └── OrderTest.java
        └── service
            └── OrderServiceTest.java
```

---

## Technologies Used

- Java 21
- Apache Maven
- JUnit 5

---

## Running the Application

### Clone the Repository

```bash
git clone <repository-url>
```

### Navigate to the Project

```bash
cd paynest
```

### Compile the Application

```bash
mvn clean compile
```

### Run the Demo Application

```bash
mvn exec:java
```

Alternatively, run the following class directly from your IDE:

```java
app.PayNestApplication
```

---

## Running Tests

Execute all tests with:

```bash
mvn test
```

---

## Example Output

```text
================================
PAYNEST ORDER SUMMARY
================================

Customer: Wesley Henry
Email: wesleyhenry@umuzi.org

--------------------------------

Laptop         x1     R12000.00
Mouse          x2     R400.00
Headphones     x5     R7500.00

--------------------------------
Grand Total: R19900.00
================================
```

---

## Design Decisions

### Why OrderItem Exists

The `OrderItem` class represents a single line in an order.

It allows:

- Separation of concerns
- Independent quantity tracking
- Individual line total calculations

Without `OrderItem`, the `Order` class would become responsible for too many tasks and would be harder to extend.

### Why Order Owns Its Items

The `Order` class manages its own collection of `OrderItem` objects.

This ensures:

- Consistent total calculations
- Better encapsulation
- Easier future enhancements such as discounts, tax calculations, and stock tracking

### Extensibility

The current design allows new product fields to be added later without changing checkout logic.

Examples:

- Product description
- Product category
- Product SKU
- Inventory quantity

Since totals are calculated using getters, the checkout process remains unchanged.

---

## Author

**Wesley Henry**

IMI Java Trainee