# Use Eclipse Temurin OpenJDK 21
FROM eclipse-temurin:21-jdk-alpine

# Install Maven
RUN apk add --no-cache maven

# Set working directory
WORKDIR /app

# Copy project files (for dev environment)
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

# Install dependencies and package the app
RUN chmod +x mvnw && ./mvnw package -DskipTests

# Expose the application port
EXPOSE 8080

# Load environment variables from .env
ENV SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL}
ENV SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME}
ENV SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}

# Run the Spring Boot application
CMD ["sh", "-c", "java -jar target/*.jar"]
