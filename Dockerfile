# Use the official OpenJDK runtime for Java 21
FROM openjdk:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/todoappbackend-0.0.1-SNAPSHOT.jar todoappbackend-0.0.1-SNAPSHOT.jar

# Expose port 8080 for the app to be accessible
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "todoappbackend-0.0.1-SNAPSHOT.jar"]
