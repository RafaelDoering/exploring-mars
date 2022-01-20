# Exploring Mars

## Running
- Install Java 11 on your computer.
- Install dependencies with `mvnw install`.
- Start the server with `mvnw spring-boot:run`.
- Server will be running on port 8080

## Main libraries
- Server
  - spring
- Database
  - mysql
- Database communication
  - jpa
- Tests
  - junit

## Architecture
- Controllers: Handle HTTP requests, execute necessary **services** and send a response back to the client.
- DTOs: Data transfer objects.
- Exceptions: Application exceptions.
- Models: Database models with business logic.
- Repository: Abstract database methods.
- Services: Execute the application logic, making operations, calling **repositories** and making API's calls.