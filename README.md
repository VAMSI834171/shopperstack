# ShopperStack Selenium Automation

A Java-based Selenium automation project for testing the [ShopperStack](https://www.shoppersstack.com/) web application.

The project uses **Maven** for dependency management and build automation, and **Selenium WebDriver** for browser automation.

## Tech Stack

* Java
* Selenium WebDriver
* Maven
* Chrome / Safari
* JUnit

## Project Structure

```text
shopperstack/
│
├── pom.xml
│
└── src/
    ├── main/
    │   └── java/
    │       └── basicScripts/
    │           └── shopperstack.java
    │
    └── test/
        └── java/
```

### File and Directory Description

| Path                          | Purpose                                      |
| ----------------------------- | -------------------------------------------- |
| `pom.xml`                     | Maven project configuration and dependencies |
| `src/main/java/`              | Main Java source code                        |
| `src/main/java/basicScripts/` | Selenium automation scripts                  |
| `shopperstack.java`           | ShopperStack automation script               |
| `src/test/java/`              | Test classes                                 |

## Prerequisites

Make sure the following are installed:

### Java

Check your Java installation:

```bash
java -version
```

### Maven

Check Maven:

```bash
mvn -version
```

### Browser

Install one of the supported browsers:

* Google Chrome
* Safari (macOS)

For Chrome, Selenium uses `ChromeDriver`.

For Safari, macOS provides `safaridriver`.

## Clone the Project

```bash
git clone <your-repository-url>
cd shopperstack
```

## Install Dependencies

Maven downloads the Selenium dependencies automatically.

Run:

```bash
mvn compile
```

## Run the Automation

The project uses the Maven Exec plugin to run the Java `main()` method.

```bash
mvn exec:java -Dexec.mainClass="basicScripts.shopperstack"
```

Or run both steps:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="basicScripts.shopperstack"
```

## Browser Configuration

### Chrome

The current script uses:

```java
WebDriver driver = new ChromeDriver();
```

This launches Google Chrome.

### Safari

On macOS, enable Safari WebDriver:

**Safari → Settings → Advanced → Show features for web developers**

Then enable:

**Develop → Allow Remote Automation**

Change the driver in the Java code:

```java
import org.openqa.selenium.safari.SafariDriver;

WebDriver driver = new SafariDriver();
```

## Maven Configuration

The main dependencies are defined in `pom.xml`.

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.35.0</version>
</dependency>
```

The Maven Exec plugin is used to run classes containing a `main()` method:

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>exec-maven-plugin</artifactId>
    <version>3.5.0</version>
</plugin>
```

## Basic Workflow

```text
Maven
  │
  ├── Download dependencies
  │
  ├── Compile Java code
  │
  └── Run Selenium script
          │
          ▼
      WebDriver
          │
          ▼
       Browser
          │
          ▼
     ShopperStack
```

## Useful Maven Commands

Compile the project:

```bash
mvn compile
```

Run the Selenium script:

```bash
mvn exec:java -Dexec.mainClass="basicScripts.shopperstack"
```

Clean compiled files:

```bash
mvn clean
```

Clean and compile:

```bash
mvn clean compile
```

Run tests:

```bash
mvn test
```

## Notes

* Selenium manages the browser driver automatically with modern Selenium versions.
* Do not commit real passwords, API keys, or personal credentials to Git.
* For reusable automated tests, prefer explicit waits such as `WebDriverWait` instead of `Thread.sleep()`.
* Test scripts can be moved into `src/test/java/` as the project evolves toward a proper test framework.

## Future Structure

As the project grows, the structure can evolve into:

```text
shopperstack/
│
├── pom.xml
├── README.md
│
└── src/
    ├── main/
    │   └── java/
    │       ├── pages/
    │       └── utils/
    │
    └── test/
        └── java/
            ├── tests/
            └── base/
```

This separates **page objects**, **utilities**, and **test cases**, making the automation project easier to maintain.
