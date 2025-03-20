
# FROM amazoncorretto:21.0.4-alpine3.18


# WORKDIR /app

# COPY target/questlab-0.0.1-SNAPSHOT.jar app.jar

# EXPOSE 8080


# ENTRYPOINT ["java", "-jar", "app.jar"]


# Use Maven with OpenJDK 21
FROM maven:3.9.9 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and the source code to the working directory
COPY . .

# Run the Spring Boot application with DevTools enabled
CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.profiles=dev", \
     "-Dspring.devtools.restart.enabled=true", \
     "-Dspring.devtools.livereload.enabled=true", \
     "-Dspring.devtools.remote.secret=mysecret"]

# mvn spring-boot:run -Dspring-boot.run.profiles=dev -Dspring.devtools.restart.enabled=true -Dspring.devtools.remote.secret=mysecret