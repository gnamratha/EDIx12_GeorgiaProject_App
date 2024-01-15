# Use the official OpenJDK base image for Java 17
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY /out/artifacts/demoSpring_jar/demoSpring.jar /app

# Specify the default command to run on container startup
CMD ["java", "-jar", "demoSpring.jar"]