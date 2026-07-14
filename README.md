# Java Hybrid Test Automation

A hybrid test automation framework built in Java, designed to provide a single, consistent
foundation for testing across multiple platforms: **Web**, **Android**, **iOS**, and **API**.

The goal of this project is to avoid maintaining separate automation codebases per platform.
Instead, common patterns (Page Objects, base test setup, assertions) are shared and extended
so that new platforms can be added without reinventing test infrastructure.

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
│   └── web/                 # Page Objects for the web application
│       ├── BasePage.java    # Shared driver access and element helpers
│       ├── LoginPage.java   # Login page interactions
│       └── ProductsPage.java
└── test/java
    ├── tests/base/
    │   └── BaseWebTest.java # Shared WebDriver setup/teardown for web tests
    └── tests/web/
        ├── LoginTests.java
        └── ProductsTests.java
```

As Android, iOS, and API coverage are added, they will follow the same pattern under
their own `main/java/{android,ios,api}` and `test/java/tests/{android,ios,api}` packages,
sharing common base classes wherever possible.

## Current Status

- ✅ **Web** — Page Object Model in place, with login and product page coverage against a
  sample e-commerce site ([saucedemo.com](https://www.saucedemo.com/)).
- 🔜 **Android** — Dependencies configured (Appium); test implementation in progress.
- 🔜 **iOS** — Dependencies configured (Appium); test implementation in progress.
- 🔜 **API** — Dependencies configured (REST Assured); test implementation in progress.

## Prerequisites

- Java 17 or later
- Maven 3.6+
- A supported browser (Chrome, Firefox, or Edge) for web tests
- For mobile tests: an Appium server, plus configured Android/iOS emulators, simulators, or
  physical devices

## Getting Started

Clone the repository and install dependencies:

```bash
git clone <repository-url>
cd java_hybridTestAutomation
mvn clean install
```

## Running Tests

Run the full test suite:

```bash
mvn test
```

Run a specific test class:

```bash
mvn test -Dtest=LoginTests
```

> **Note:** Web tests currently launch Chrome by default and target `https://www.saucedemo.com/`.
> WebDriverManager handles browser driver downloads automatically, so no manual driver
> installation is required.

## Design Principles

- **Page Object Model** — UI interactions are encapsulated in page classes (see `web/BasePage.java`,
  `web/LoginPage.java`), keeping test classes focused on test logic and assertions rather than
  element locators.
- **Shared base test classes** — Common setup and teardown (e.g., driver initialization,
  session cleanup) live in base test classes like `BaseWebTest`, so individual test classes
  stay lean.
- **Extensible by platform** — The same architecture is intended to extend to Android, iOS, and
  API testing, allowing shared utilities and consistent conventions across the whole suite.

## Roadmap

- [ ] Add Android test suite using Appium
- [ ] Add iOS test suite using Appium
- [ ] Add API test suite using REST Assured
- [ ] Externalize configuration (URLs, credentials, environments) out of test/source files
- [ ] Add CI pipeline for automated test execution

## Contributing

This project is under active development. When adding new platform support, follow the
existing Page Object and base test class conventions to keep the framework consistent.