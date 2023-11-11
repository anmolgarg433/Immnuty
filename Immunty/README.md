# Product Management System

This is a RESTful API service for a digital product management system, reflecting a simplified version of a B2B SaaS product.

## Technology Stack

- **Node.JS** for the main server-side logic
- **Java** for a secondary service that processes product price updates
- **MongoDB** for the database

## Requirements

1. **Node.JS Endpoints:**
   - `GET /products` - Retrieve a list of all products.
   - `GET /products/{product_id}` - Retrieve details of a specific product.
   - `POST /products` - Add a new product.
   - `PUT /products/{product_id}` - Update details of a specific product.
   - `DELETE /products/{product_id}` - Remove a specific product.

2. **Java Service:**
   - Create a small Java service that receives price update requests, processes them, and then updates the relevant product information in the database.

3. **Validation:**
   - Ensure all necessary fields are provided when creating or updating products.
   - Ensure the product price is a positive value.

4. **Error Handling:**
   - Handle common errors gracefully (e.g., product not found, invalid data, etc.) and return appropriate error messages.

5. **Documentation:**
   - Provide a README explaining how to set up and run your service, and how to use each endpoint (include example requests and responses).

6. **Testing:**
   - Include basic tests to verify that your service works as expected.

7. **Bonus:**
   - Implement a simple authentication mechanism.
   - Implement a filtering feature on the `GET /products` endpoint to search products based on name or price range.

## Getting Started

### Prerequisites

- Node.js
- Java
- MongoDB

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/product-management-system.git
   cd product-management-system

Install Node.js dependencies:

Copy code
cd nodejs
npm install

Install Java dependencies:

Copy code
cd java
mvn clean install
Run the application:

Start the Node.js server:

Copy code
cd nodejs
npm start

Start the Java service:

Copy code
cd java
java -jar target/product-service.jar

Usage

Detailed information on how to use each endpoint is available in API Documentation.

Testing
Run tests for the Node.js application:
Copy code
cd nodejs
npm test


Run tests for the Java service:
Copy code
cd java
mvn test

Contributors
Anmol garg
