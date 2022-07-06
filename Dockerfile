FROM maven:3.8.5-openjdk-17 AS build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

FROM openjdk:17-alpine
COPY --from=build /app/target/rest-0.0.1-SNAPSHOT.jar /usr/local/lib/rest.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/rest.jar"]
