# Stage 1: Build the Application using Maven Wrapper
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copy Maven wrapper and configuration files first
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Grant execution permissions to maven wrapper
RUN chmod +x mvnw

# Download dependencies (Cache layer)
RUN ./mvnw dependency:go-offline -B

# Copy actual source code and build final JAR
COPY src ./src
RUN ./mvnw clean package -DskipTests -B

# Stage 2: Minimal Runtime Environment
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]