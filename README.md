# CLM Automation using Selenide and Cucumber BDD

This project is to automate CLM use cases like registrations and service requests, which is required for Sanity and Regression.

**Technologies Used:**

- Selenium (Java)
- TestNG
- Maven
- Cucumber BDD
- Cucumber Extent Reports

**Java Libraries Used:**

- Selenide
- Apache - POI
- SLF4J
- Google - Guava
- QA Tools - Ashot
- Oracle JDBC

**Steps to Run:**

- Import project as Maven project to your Eclipse IDE
- Install TestNG & Cucumber Plugins
- Change configs under configs folder
    -  Browser
    -  Environment
    -  Selenide configs
        - holdBrowserOpen
        - headless
        - implicitWait
        - screenshotRequiredForPassedAlso
- Update static data under src/test/resources/testData folder
- Update dynamic test data in feature files under src/test/resources/functionalTests folder
- Run your test as TestNG suite (e.g., src/test/java/framework/runners/RegistrationTest.java)
    - Specify the tags if you would like to run any specific scenarios

**Development:**

- Prepare feature files with Steps
- Write step definitions under src/test/java/stepDefinitions
- Create Page Classes under src/main/java/pages
- Add logger and screenshot wherever required

**Advantages over existing Robot framework Automation Solution:**

- Test cases can be run in parallel mode
- No need to use any sleeps/waits, which will save both script development and execution time
- Screenshots can be captured dynamically wherever test execution fails, even for passed also
- Video recording of the test execution also can be done if needed
- Excellent graphical report with analytics/filters and timeline
- Supports tagging of the feature/scenario. So, we can run specific test cases dynamically
- Can be run headless (without opening a browser)
- Followed Page Object Model (POM), so the maintenance is easier
- No need to download the browser driver executable, wherever there is browser upgrade
- No need to install oracle client
- Script preparation and execution are faster by using Selenide
