# Java Hybrid Test Automation

A hybrid test automation framework built in Java, designed to provide a single, consistent
foundation for testing across multiple platforms: **Web**, **Android**, **iOS**, and **API**.

The goal of this project is to avoid maintaining separate automation codebases per platform.
Instead, common patterns (Page Objects, driver factories, base test setup, assertions) are
shared and extended so that new platforms can be added without reinventing test infrastructure.

## Tech Stack

| Purpose            | Tool                                                              |
|---------------------|--------------------------------------------------------------------|
| Language / Build   | Java 17, Maven                                                    |
| Web UI Automation  | [Selenium WebDriver](https://www.selenium.dev/)                   |
| Mobile Automation  | [Appium Java Client](https://github.com/appium/java-client)       |
| API Testing        | [REST Assured](https://rest-assured.io/)                          |
| Test Runner        | [TestNG](https://testng.org/)                                     |
| Driver Management  | [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) |

## Project Structure

```
src
├── main/java
│   ├── api/          # POJOs for API resources
│   ├── drivers/
│   │   ├── config/   # Reads configuration from config.properties
│   │   └── factory/
│   │       └── manager/  # One manager per browser/platform (Chrome, Firefox, Edge, Safari,
│   │                     # Android, iOS), used by the Web/Appium driver factories
│   ├── mobile/        # Screen Objects for the mobile app
│   └── web/           # Page Objects for the web application
└── test
    ├── java
    │   └── tests/
    │       ├── base/  # Shared base test classes (setup/teardown per platform)
    │       ├── web/   # Web test classes
    │       ├── mobile/# Mobile test classes
    │       └── api/   # API test classes
    └── resources/     # config.properties (web, mobile, and API configuration)
```

## Current Status

- ✅ **Web** — Page Object Model in place, the AUT (Application Under Test) is the sample e-commerce site ([saucedemo.com](https://www.saucedemo.com/)).
- ✅ **Android / iOS** — `AppiumDriverFactory` selects the driver manager for the platform to be tested on. Uses the my-demo-app of SauceLabs as AUT.
- ✅ **API** — `BaseAPITest` provides REST Assured request/response spec builders. The [Swagger Petstore](https://petstore.swagger.io/v2) is selected as the AUT (API Under Test)
- ✅ **Driver management** — `WebDriverFactory` and `AppiumDriverFactory` implement a factory
  pattern, delegating to per-browser/per-platform manager classes.
- ✅ **Configuration** — Web, mobile, and API settings are externalized to
  `src/test/resources/config.properties` and read via `ConfigReader`.

> **Note:** This project is currently a local-only setup — there is no CI pipeline or remote
> device/browser grid. Tests are run from a local machine against locally installed browsers,
> local emulators/simulators or connected physical devices, and the Appium server is expected
> to be running locally.

## Prerequisites

- Java 17 or later
- Maven 3.6+
- A supported browser (Chrome, Firefox, Edge, or Safari) for web tests
- For mobile tests: a local Appium server, plus configured Android/iOS emulators, simulators,
  or physical devices, matching the values set in `config.properties`

## Getting Started

Clone the repository and install dependencies:

```bash
git clone <repository-url>
cd java_hybridTestAutomation
mvn clean install
```

Configuration for web, mobile, and API tests lives in `src/test/resources/config.properties`
(base URLs, browser, mobile platform/capabilities, Appium server URL). Update it to match your
local environment and devices before running tests.

## Running Tests

Run the full test suite:

```bash
mvn test
```

Run a specific test class:

```bash
mvn test -Dtest=LoginTests
```

> **Note:** Web tests launch the browser configured in `config.properties` (`web.browser`)
> against `web.baseUrl`. WebDriverManager handles browser driver downloads automatically.
> Mobile tests require an Appium server reachable at `mobile.appiumServerUrl` and target the
> platform set in `mobile.platform` (`android` or `ios`). API tests call `api.baseUrl` directly
> and require no additional setup.

## Design Principles

- **Page/Screen Object Model** — UI interactions are encapsulated in page classes (`web/`) and
  screen classes (`mobile/`), keeping test classes focused on test logic and assertions rather
  than element locators.
- **Driver Factory pattern** — `WebDriverFactory` and `AppiumDriverFactory` centralize driver
  creation behind per-browser/per-platform manager classes, so adding a new browser or platform
  doesn't require changes to test code.
- **Shared base test classes** — Common setup and teardown (driver initialization, session
  cleanup, REST Assured spec setup) live in base test classes (`BaseWebTest`,
  `BaseMobileAppTest`, `BaseAPITest`), so individual test classes stay lean.
- **Externalized configuration** — Environment-specific values (URLs, credentials, device
  capabilities) live in `config.properties` rather than hardcoded in test/source files.

## Roadmap

- [x] Add Android test suite using Appium
- [x] Add iOS test suite using Appium
- [x] Expand API test suite using REST Assured
- [ ] Implement test suites in TestNG using XML files (e.g. `testng.xml`) to group and control
  execution of the web, mobile, and API test suites
- [ ] Add CI pipeline for automated test execution
