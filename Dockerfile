# Use the official Amazon Corretto image (Amazon's OpenJDK distribution)
FROM amazoncorretto:17

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the target directory into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Entry point for the container. This will run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]