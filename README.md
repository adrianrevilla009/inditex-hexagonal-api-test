# Hexagonal arquitecture microservice for inditex code test
==================================

### Adrian Revilla

[**Github**](https://github.com/adrianrevilla009)

[**Linkdn**](https://www.linkedin.com/in/adrian-revilla-8a4097130)

Project features
------------
------------
The chosen approach is to implement a hexagonal architecture to separate domain to
the other layers giving more abstraction to the code.

There are separated profiles to run them depending on desired environment.

There is a .github directory with PR and push triggers on develop and master. Besides that,
when master is triggered, a docker image is generated and pushed to registry (for this, is required to
set credentials in github repository)

Source code contains:
- API controller
- Bean configurator
- Database initializer
- Domain with dto, ports and services
- Infrastructure for persistence layer with entities and repositories
- Swagger documentation

Test code contains:
- Unit testing
- Integration testing

A postman collection is included to reach api endpoints.

A dockerfile to containerize the java app.

Execution
------------
------------
To run the app, just type: 
```
mvn clear build
```
Then run:
```
java -jar target_directory/api-test-1.0.0-RC.jar
```






