## Project Name: EventWise - A Microservices-Based Event Planning Platform

### Objective:

Develop "EventWise," a simplified event planning platform to demonstrate microservices architecture using Spring Boot. This system will consist of separate microservices for client management, vendor services, and event scheduling.

### Tasks:

1. **Project Setup:**
   - Initialize the project using Spring Initializr. Select Spring Web, Spring Data JPA, H2 Database, and Lombok as dependencies.
   - Create three microservices: `ClientService`, `VendorService`, and `EventService`.
   - Ensure that each microservice is in its separate module with its own `pom.xml` file.

2. **Microservice Design:**
   - **ClientService:**
     - Manages client registrations and information.
     - Endpoints:
       - Register a new client (POST)
       - Retrieve client details (GET)

   - **VendorService:**
     - Manages vendor registrations, services they offer, and their availability.
     - Endpoints:
       - Register a new vendor (POST)
       - Add/Update services offered (POST/PUT)
       - Check vendor availability (GET)

   - **EventService:**
     - Handles the creation, update, and retrieval of events.
     - Endpoints:
       - Schedule a new event (POST)
       - Update an event (PUT)
       - Retrieve event details (GET)

3. **Inter-Service Communication:**
   - `EventService` should verify client details with `ClientService` and vendor availability with `VendorService` before confirming an event.
   - Implement RESTful communication using Spring's `WebClient`.

4. **Data Persistence:**
   - Design and implement the database schema for each service. Consider entities like Clients, Vendors, Events, and Services.
   - Use JPA Repositories for data access and the H2 in-memory database for simplicity.

5. **Exception Handling:**
   - Create custom exceptions and handle them gracefully, providing meaningful responses to the client. For example, handle cases like "Vendor Not Available," "Invalid Client ID," etc.

6. **Configuration:**
   - Externalize your configuration. Use Spring's `@ConfigurationProperties` or a configuration server to manage service URLs, database connections, etc.

7. **Testing:**
   - Write unit tests for crucial components and endpoints in each service. Ensure that you're testing both positive and negative scenarios.
   - Use `MockMvc` for testing the web layer and `@DataJpaTest` for repository tests.
