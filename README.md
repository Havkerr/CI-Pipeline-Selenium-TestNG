CICD_Selenium

A Selenium + TestNG + Maven test automation project using the Page Object Model.

Tech Stack:
- Java 25
- Maven
- TestNG
- Selenium WebDriver
- WebDriverManager

Project Structure:
- src/main/java/com/portfolio/qa/pages - Page objects (BasePage, LoginPage, SecureAreaPage)
- src/test/java/com/portfolio/qa/tests - Test classes (BaseTest, LoginTest)
- src/test/resources/testng.xml - TestNG suite config

Prerequisites:
- JDK 25
- Maven
- Google Chrome

How to Run:
mvn test

Test reports are generated in target/surefire-reports.

What's Tested:
- Login flow: verifies successful login redirects to the secure area.
