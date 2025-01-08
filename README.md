# altonaut-web-ui-automation

## Running Tests

### Prerequisites
- Java Development Kit (JDK)
- Maven or Gradle
- WebDriver binaries (e.g., ChromeDriver, GeckoDriver)

### Running Tests in Headless Mode

To run the tests in headless mode, ensure that the `Config.BROWSER` is set to either `chrome` or `firefox`. The `BaseTest` class has been configured to run in headless mode by default.

#### Using Maven
```sh
mvn clean install
mvn test