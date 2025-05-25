 # Java Selenium Demo
 This is a template framework for testing/interviewing purpose.
- Language: Java.
- Automation tool: Selenium.
- Testing framework: TestNG.
- BDD framework: Cucumber.
- Build tool: Maven.

## CLI commands
### Docker:
```
# To create a new network
docker network create grid

# To see all networks
docker network ls

# Download the image of selenium standalone chrome
docker pull selenium/standalone-chrome:121.0

# Create a container for selenium standalone chrome
docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --net grid --name selenium-hub selenium/standalone-chrome:121.0

# Create docker image from my test source
docker build -t selenium_saucedemo .

# Add /bin/bash if you want to stay in the terminal after creating the container
docker run -it --net grid --name selenium_saucedemo_container selenium_saucedemo /bin/bash
```

```
# Selenium Grid UI
http://localhost:4444/ui

# To get access into the Selenium Grid server
http://localhost:7900/?autoconnect=1&resize=scale&password=secret
```

### To copy all dependencies into "lib" folder:
```
mvn dependency:copy-dependencies -DoutputDirectory=lib/ -DskipTests=true
```

### To clean and compile source code under `src/main`:
```
mvn clean compile
```

### To clean and compile source code under `src/test`:
```
mvn clean test-compile
```

### To run all tests from LoginTest class:
```
mvn clean test -Dtest=LoginTest
```

### To run only testLogin() from LoginTest class:
```
mvn test -Dtest="LoginTest#testLogin"
```
