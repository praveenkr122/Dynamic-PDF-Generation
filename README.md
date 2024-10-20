# Dynamic-PDF-Generation
Overview
This application provides an API endpoint that accepts a request containing invoice or bill details and dynamically generates a PDF file based on the provided data. The PDF is returned as a downloadable file, and it includes:

Seller and Buyer details.
A table displaying items, quantities, rates, and total amounts.
The layout is generated using iText 7, and a custom PDF template is rendered using Thymeleaf.
Technologies Used
Spring Boot 3.4.0
iText 7 (PDF generation)
kernel (Core PDF functionalities)
layout (Building tables and layouts in PDFs)
Thymeleaf (Template engine for dynamic PDF generation)
Java 17
Prerequisites
Java 17 or higher installed
Maven installed (for dependency management)
Any API client such as Postman for testing
Installation
Clone the repository:

bash
Copy code
git clone https://github.com/your-username/pdf-generator-springboot.git
cd pdf-generator-springboot
Update dependencies: Make sure you have the necessary dependencies installed by running:

bash
Copy code
mvn clean install
Run the application: Start the Spring Boot application using:

bash
Copy code
mvn spring-boot:run
The application will be accessible on http://localhost:8080.
