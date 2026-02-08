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

- **System Testing (Black-box Testing)**
Testing the fully deployed application end-to-end through the real UI. This verifies that all components (frontend, backend, database, authentication) work together as a complete system. Example scenarios: user logs in via OAuth → completes onboarding → manages inventory → processes a sale at POS → verifies sales statistics. System testing is performed manually after live deploy in production server.

- **Acceptance (Manual) Testing (Black-box Testing)**
Developers test their bug fixes or new features manually before opening a pull request. The PR reviewer also verifies that all Issue Acceptance Criteria are fulfilled. This level ensures the application meets user requirements and functions as expected from an end-user perspective.

### Test scope

**In scope — Backend (automated + manual):**
- Authentication and authorization: OAuth2 login flow, JWT token generation and validation, role-based access control (ADMIN vs USER)
- Onboarding: organization selection, role assignment, redirect logic
- Organization management: CRUD operations, data isolation between organizations
- Category management: CRUD operations, duplicate name detection (case-insensitive)
- Product management: CRUD operations, organization scoping, category association
- Inventory operations: add/remove/adjust stock, non-negative quantity validation, transaction audit trail
- Sales processing: multi-item sales, dynamic pricing calculations, price caps (min/max), stock deduction
- Sales statistics: aggregation per user, per station, revenue calculations
- Bar station management: CRUD operations, user assignment, ADMIN-only access

Currently automated test coverage (line coverage) is **68%**. See [JaCoCo Coverage Report](https://onedrive.live.com/?qt=allmyphotos&photosData=%2Fshare%2F2F84D485850C457E%21s63f03133d1df418a938c3ea399218bbf%3Fithint%3Dphoto%26e%3DspTHKL%26migratedtospo%3Dtrue&cid=2F84D485850C457E&id=2F84D485850C457E%21s63f03133d1df418a938c3ea399218bbf&redeem=aHR0cHM6Ly8xZHJ2Lm1zL2kvYy8yZjg0ZDQ4NTg1MGM0NTdlL0lRQXpNZkJqMzlHS1FaT01QcU9aSVl1X0FiUktmTjBRQ0Zmbkkxbk1vVXd2TzE4P2U9c3BUSEtM&v=photos) for details.

**In scope — Frontend (manual):**
- Login page and OAuth2 redirect flow
- Onboarding flow (organization selection, terms acceptance)
- Dashboard and statistics display
- Inventory management page (products, categories, stock operations)
- POS interface (station selection, product browsing, cart, sale processing)
- Navigation, routing, and middleware (authenticated vs public routes)

**Out of scope:**
- Third-party service internals (Google OAuth provider, PostgreSQL engine)
- Deployment infrastructure and server configuration
- Browser compatibility testing beyond latest Chrome/Firefox/Safari
- Performance and load testing

### Test approach

**Backend unit tests:**
- Framework: JUnit 5 with Mockito for mocking dependencies
- Each service class has a corresponding test class (e.g., `SalesServiceTest`, `InventoryServiceTest`)
- Tests mock repository and dependency calls to isolate business logic
- Run locally with `./mvnw test` before every PR

**Backend integration tests:**
- Framework: Spring MockMvc with H2 in-memory database
- Each controller has a corresponding test class (e.g., `SalesControllerTest`, `AuthControllerTest`)
- Tests verify full request/response cycle: HTTP method, URL, headers, request body, response status, and response body
- Authentication is simulated using test JWT tokens

**Frontend testing:**
- Currently manual only: developers verify UI behavior in the browser before submitting PRs
- PR reviewers check the UI against acceptance criteria

**Test execution flow:**
1. Developer writes or updates tests alongside code changes
2. Developer runs `./mvnw test` locally to verify all tests pass
3. Developer performs manual testing of the affected feature in the browser
4. Developer opens a PR — CI pipeline runs the full test suite automatically
5. PR reviewer verifies acceptance criteria manually and reviews test coverage

### Test environment

- **Local development:** Docker Compose running PostgreSQL 17, Spring Boot backend (port 8080), Next.js frontend (port 3000). Environment variables loaded from `.env` files.
- **Automated test database:** H2 in-memory database used by backend integration tests (separate from the development PostgreSQL instance, no setup required)
- **CI pipeline:** Github Actions workflow runs Maven build and tests on every pull request using Java 21 and Node.js
- **Production server:** Ubuntu 24.04 at `193.40.157.60` with nginx. Used for system-level testing of the deployed application.

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
- Code is approved and merged after PR review

### Roles and Responsibilities
We have a dynamic team structure, which means that each team member has the role and responsibilities of a tester. All developers are expected to:
- Write and maintain unit and integration tests for their code changes
- Perform manual testing before submitting pull requests
- Review and test code during PR reviews
- Report and document any bugs or issues discovered during testing
- Contribute to improving the overall test coverage and quality


### Risks and assumptions

**Risks:**
- Limited test coverage due to time constraints — not all edge cases may be covered
- No dedicated tester — testing quality depends on each developer's diligence
- Environment differences between local Docker setup and production server may cause unexpected bugs
- No automated frontend tests — UI regressions can only be caught manually

**Assumptions:**
- All team members have sufficient knowledge to write and maintain backend tests
- The H2 in-memory database behaves similarly enough to PostgreSQL for integration tests
- Manual testing is sufficient for frontend coverage at the current project scale
- CI pipeline will catch test failures before code is merged to main

### Test deliverables
- Unit test cases located in `backend/src/test/java/com/borsibaar/` (service tests)
- Integration test cases located in `backend/src/test/java/com/borsibaar/` (controller tests)
- Automated test results from `./mvnw test` and CI pipeline reports
- Bug reports and issue tickets filed in GitHub Issues
- Pull request reviews with testing feedback
- This test plan document (maintained and updated as the project evolves)
