
# Use the official OpenJDK 17 image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the  main folder from the host to the working container
COPY src/main /app/Main.java

#Compile the java code
RUN javac Main.java

# Run the compiled java code
CMD ["java", "Main"]