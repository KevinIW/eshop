# Use a base image with JDK and Gradle installed
FROM gradle:7.3.3-jdk17 AS builder

# Set the working directory in the container
WORKDIR /src/advshop

# Copy Gradle files
COPY build.gradle settings.gradle ./

# Copy the source code
COPY src ./src

# Build the application
RUN gradle clean bootJar

# Use a lightweight JRE image for the application runtime
FROM adoptopenjdk:17-jre-hotspot

ARG USER_NAME=advshop
ARG USER_UID=1000
ARG USER_GID=${USER_UID}

# Create a non-root user
RUN addgroup -g ${USER_GID} ${USER_NAME} \
    && adduser -h /opt/advshop -D -u ${USER_UID} -G ${USER_NAME} ${USER_NAME}

USER ${USER_NAME}

# Set the working directory
WORKDIR /opt/advshop

# Copy the JAR file built in the previous stage
COPY --from=builder --chown=${USER_UID}:${USER_GID} /src/advshop/build/libs/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
