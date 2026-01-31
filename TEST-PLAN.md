## TEST PLAN

### Introduction
This is our project's comprehensive test plan which explains point by point how testing is conducted throughout the development process. This document serves as a guide for all team members to ensure consistent quality standards and testing practices across the Borsibaar bar management system.


### Testing Objectives
Our main objective for testing is to raise the quality of our application by: 
- Reducing the number of bugs and unwanted behavior that could occur
- Following the exact feature criteria provided by the client
- Ensuring our new features won't break existing functionality (regression prevention)
- Ensuring we don't produce broken features before they reach production
- Maintaining code reliability and stability throughout the development lifecycle
- Providing rapid feedback to developers on code quality
    

### Testing Levels

- **Unit Testing (White-box Testing)**
For backend services and helper functions. When a developer makes changes to business logic, they must also update the related tests or write new ones if they don't exist.

    * **Current Status:** At the moment, there are no unit tests for the frontend, but depending on time and resources, we might start writing unit tests for our frontend components as well.

- **Integration Testing (White-box Testing)**
For backend APIs. Developers who make changes to the API logic or structure need to also update or write new tests for the appropriate controllers. These tests verify that the API endpoints return the correct response structure and status codes.

- **Acceptance (Manual) Testing (Black-box Testing)**
Developers test their bug fixes or new features manually before opening a pull request. The PR reviewer also verifies that all Issue Acceptance Criteria are fulfilled. This level ensures the application meets user requirements and functions as expected from an end-user perspective. 

### Test scope
### Test approach
### Test environment
### Entry and exit criteria
### Roles and Responsibilities
We have a dynamic team structure, which means that each team member has the role and responsibilities of a tester. All developers are expected to:
- Write and maintain unit and integration tests for their code changes
- Perform manual testing before submitting pull requests
- Review and test code during PR reviews
- Report and document any bugs or issues discovered during testing
- Contribute to improving the overall test coverage and quality


### Risks and assumptions
### Test deliverables