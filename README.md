 # Java Selenium Demo
 This is a template framework for testing/interviewing purpose.
- Language: Java.
- Automation tool: Selenium.
- Testing framework: TestNG.
- BDD framework: Cucumber.
- Build tool: Maven.

## CLI commands
### To copy all dependencies into "lib" folder:
```
mvn dependency:copy-dependencies -DoutputDirectory=lib/ -DskipTests
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
mvn test -Dtest="LoginTest"
java -cp "target\test-classes;lib\*" org.testng.TestNG -testclass "com.giaphi.demo.tests.LoginTest"
```

### To run only testLogin() from LoginTest class:
```
mvn test -Dtest="LoginTest#testLogin"
```
