# Spring Boot testing

This is a demo Spring boot app: it only contains 1 
controller with a few endpoints. Data is stored 
in a PostgreSQL database.

## Unit testing

[Unit testing example](src/test/java/com/epam/gaspar/securitydemo/service/DataServiceTest.java) provided for one class, a service.
Dependencies (the database) are mocked out.

Test suite is not complete, but the other classes could be 
tested similarly.

## Integration testing

[Integration tests](src/integrationTest/java/com/epam/gaspar/securitydemo/controller/DataControllerIntegrationTest.java) launch the entire app. During 
these tests and actual Postgres DB is launched in Docker, 
which is then destroyed after the tests end. This functionality
is provided by the [Testcontainers framework](https://testcontainers.com/).

`MockMvc` is used to make HTTP requests to the application.

Test suite is not complete, but the other endpoints
could be tested similarly.