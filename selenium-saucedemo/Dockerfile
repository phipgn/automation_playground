FROM maven:3.9.6-eclipse-temurin-17-alpine

WORKDIR /workspace/test/
COPY src ./src
COPY pom.xml .
COPY testng.xml .

RUN mvn clean test -DskipTests

CMD ["mvn", "clean", "test", "-Dtest=LoginTest"]