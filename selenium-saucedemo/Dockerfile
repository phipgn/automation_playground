FROM maven:3.9.6-eclipse-temurin-17-alpine

WORKDIR /workspace/test/
COPY src ./src
COPY config.json .
COPY pom.xml .
COPY testng.xml .

# To prefetch all dependencies
RUN mvn dependency:go-offline

# Default command that runs when the container starts
CMD ["mvn", "test"]
# CMD ["mvn", "test", "-DsuiteXmlFile=testng.xml"]