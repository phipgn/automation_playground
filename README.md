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
docker network create grid
docker pull selenium/standalone-chrome:121.0
docker run -it --net grid --name my_test_c my_test /bin/bash
docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --net grid selenium/standalone-chrome:120.0
docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" selenium/standalone-chrome:120.0
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
java -cp "target\test-classes;lib\*" org.testng.TestNG -testclass "com.giaphi.demo.tests.LoginTest"
```

### To run only testLogin() from LoginTest class:
```
mvn test -Dtest="LoginTest#testLogin"
```
