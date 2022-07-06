# Spring Boot RESTful API Demo

## Execution

### Visual Studio Code

Install [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack) and start the application from the Spring Boot Dashboard.

### Shell

```sh
./mvnw spring-boot:run
```

### Docker

```sh
docker build --tag java-api-rest .
docker run --name java-api-rest --publish 8080:8080 java-api-rest
```

### Podman

If using macOS, start the Podman machine first.

```sh
podman machine init
podman machine start
```

```sh
podman build --tag java-api-rest .
podman run --name java-api-rest --publish 8080:8080 java-api-rest
```

## Documentation

* Actuator: <http://localhost:8080/v3/api-docs>
* Swagger UI: <http://localhost:8080/swagger-ui.html>
