# Demo for Spring Request Scoped bean

Demonstration of a Spring Boot project using a context object whose lifecycle is bound to the request.

The javax.inject API is used to avoid passing the context object by parameter to each and every service layer.
This API is already used by Spring to implement its dependency injection mechanism, but it is not directly accessible.
That's why we add it explicitly in the project dependencies.

Inspired by [Spring MVC - Request Scoped Bean](https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/request-scope.html) post on LogicBig.com

Project based on [Spring Initializr](https://start.spring.io/)

## Installation

Use Maven to generate the application. Not very useful, but use it if you wish !

```bash
mvn clean install
```

## Usage

Exposed REST API :

| Verb | Route          | Parameter         | Response     |
|------|----------------|-------------------|--------------|
| GET  | /poneys/{cute} | "true" OR "false" | Poney object |
| GET  | /poneys/cute   |                   | Poney object |
| GET  | /poney/lame    |                   | Poney object |
