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
The test scope covers all backend API endpoints and frontend features. Automated unit, integration tests and manual acceptance test is in scope for backend. Manual testing only for frontend, for now. Out of scope: third-party service internals, and deployment/infrastructure.

### Test approach
### Test environment
### Entry and exit criteria
Entry criteria:
- Feature implementation or bug fix is completed
- Code is committed and builds successfully
- Relevant unit and/or integration tests are written or updated
- Test environment is available and functional

Exit criteria:
- All relevant automated tests pass successfully both locally and in the CI workflow (when opening a PR)
- Manual acceptance testing is completed
- All critical and high-severity issues are resolved
- Feature meets the acceptance criteria defined in the issue

Code is approved and merged after PR review

### Roles and Responsibilities
We have a dynamic team structure, which means that each team member has the role and responsibilities of a tester. All developers are expected to:
- Write and maintain unit and integration tests for their code changes
- Perform manual testing before submitting pull requests
- Review and test code during PR reviews
- Report and document any bugs or issues discovered during testing
- Contribute to improving the overall test coverage and quality


### Risks and assumptions
Limited test coverage due to time constraints, potential environment differences between development and production causing unexpected bugs, and the dynamic team structure meaning no dedicated tester. We also assume that all team members have sufficient knowledge to write and maintain tests for their code.

### Test deliverables
- Unit test cases and integration test cases
- Automated test results (pass/fail reports)
- Bug reports and issue tickets
- Pull request reviews with testing feedback
- Test-related documentation and updates
- Final confirmation that features meet acceptance criteria
