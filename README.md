# cleartrip
Here is my testing automation demo project of https://www.cleartrip.com site

## Running the tests
There are few different ways how to run the tests.. The main approach is run tests by maven command
````
mvn clean test -Dsuite=testng.xml
````
Other way to run tests is create new configuration in IntelliJ IDEA:

````
command line: clean test
profiles: tests
````

All above approaches are defined in POM profile tag

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management

## Used frameworks and libraries
* [TestNG](https://testng.org/doc/)
* [Selenium WebDriver](https://www.selenium.dev/documentation/en/webdriver/)
* [Lombok](https://projectlombok.org/)
* [AspectJ](https://www.eclipse.org/aspectj/)
* [Logback](http://logback.qos.ch/documentation.html)
