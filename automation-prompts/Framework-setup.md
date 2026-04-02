#Automation Framework setup prompt

##1. Already Created utilities folder inside (src/test/java/utilities)
###1. Create a new class inside utilities package 
-Name: FileUtil
-Purpose: TO read External Files like .Properties,.xlsx.. and return the file
- create parameterized method and used parameter String filePath read by using FileInputStream and return the file
-Create static FileInputStream variable and assign the file to it and return the file
-return file content as String
- handle exception by using try catch block and print stack trace


###2.Create ExtentReportUtil Class inside utilities package
-Name: ExtentReportUtil
-Purpose: To create and manage Extent Reports for test execution
-Report should be save inside target folder inside target folder create new folder name as ExtentReport
-create methods inside class to initialize report, startReport,flushReport and attachReporter
use singleton design pattern to ensure only one instance of ExtentReport is created
-Use ExtentSparkReporter to create a spark report and set the report name and document title
-extent report call in base class setup method to initialize the report before test execution and flush the report after test execution
-handle exception by using try catch block and print stack trace
-static method to return the instance of ExtentReport for further use in test classes or listeners

###3.create new class captureScreenShotUtil inside utilities package
-Name: CaptureScreenShotUtil
-Purpose: To capture screenshots during test execution and save them in a specified location
-create method takeScreenShot with parameter WebDriver driver and String screenshotName
-use TakeScreenshot interface to capture the screenshot and save it in a specified location with the given screenshot name
-handle exception by using try catch block and print stack trace
-this method call inside listeners class implemented methods like pass, fail and skip
-static method to return the path of the saved screenshot for further use in reports or logs

###4. Create new class Listeners inside utilities package
-Name: ListenersUtil
purpose: To implement methods and listen to test execution events and perform actions based on the test results
- call takeScreenShot method from CaptureScreenShotUtil class to capture screenshots on test failure and attach them to the report
- use ExtentReportUtil class to log test results and update the report based on the test
- handle exception by using try catch block and print stack trace
- implement methods like onTestStart, onTestSuccess, onTestFailure and onTestSkipped
- onTestStart method to log the start of the test and create a new test entry in the report

###5.create class ActionsUtils inside utilities package
-Name: ActionsUtils
-Purpose: To perform common actions on web elements during test execution
-create methods for common actions like click, sendKeys, selectFromDropdown, hoverOverElement etc
-use WebDriver and WebElement to perform actions on web elements
-handle exception by using try catch block and print stack trace
- this class can be used in test classes to perform actions on web elements without repeating code and
- also add select class method used method overloading to select from dropdown by visible text, value and index
-static method to return the instance of ActionsUtils for further use in test classes or listeners

6. Create new class WaitUtils inside utilities package
-Name: WaitUtils
-Purpose: To implement explicit and implicit waits for web elements during test execution
-create methods for explicit wait like waitForElementToBeVisible, waitForElementToBeClickable
-use WebDriverWait and ExpectedConditions to implement explicit waits
-Explicit wait should accept WebDriver, WebElement, timeout
-implicit wait should accept WebDriver and timeout
-handle exception by using try catch block and print stack trace



##Base Class setup(src/test/java/baseclass) already created packages
###1. create browserSetup Interface inside baseclass package
-Name: BrowserSetup
-Purpose: To define the method for browser setup and initialization
-create abstract method browserSetup with parameter String browserName

###2. create new separate class chromeBrowserSetup, FirefoxBrowserSetup and edgeBrowserSetup inside baseclass package
-Name: ChromeBrowserSetup, FirefoxBrowserSetup, EdgeBrowserSetup
-Purpose: To implement the browser setup and initialization for Chrome, Firefox and Edge browsers respectively
-return webdriver instance after initializing the browser
-create WebDriver variable and initialize it based on the browser name passed as parameter
- used try catch block to handle exception and print stack trace

###3. Create new class BrowserFactory inside baseclass package
-Name: BrowserFactory
-Purpose: To create a factory class that will return the appropriate browser setup instance based on the
-browser name passed as parameter
-create method getBrowserSetup with parameter String browserName
-used singleton design pattern to ensure only one instance of browser setup is created

###4. Create new class ReadConfig inside baseclass package
-Name: ReadConfig
-Purpose: To read configuration properties from a .properties file and provide access to the configuration values
-create method getProperty with parameter String key
-use FileUtil class to read the .properties file and return the value associated with the given key
-handle exception by using try catch block and print stack trace
-using singleton design pattern to ensure only one instance of ReadConfig is created and provide global access to configuration values

###5.Craete new class BaseClass inside baseclass package
-Name: BaseClass
-Purpose: To serve as the base class for all test classes, providing common setup and teardown
-call BrowserFactory to initialize the browser before test execution and close the browser after test execution
-browser name get from property file and pass to BrowserFactory. BrowserFactory will return driver instance based on the browser name
-useing driver instance apply implicit wait and maximize the browser window
-call ExtentReportUtil to initialize the report before test execution and flush the report after test execution
-handle exception by using try catch block and print stack trace
-used Hooks @annotation to define setup and teardown methods that will be executed before and after each test scenario
-create WebDriver static and property static  file variable to store the driver instance and configuration values for use in test classes

##Create runner package inside src/test/java
name: runner
Purpose: To create a test runner class that will execute the test scenarios defined in feature files

###1. create new class TestRunner inside runner package
-Name: TestRunner
-Purpose: To serve as the test runner class that will execute the test scenarios defined in feature
-use CucumberOptions annotation to specify the location of feature files, step definitions and plugins for reporting
use JUnit or TestNG as the test runner framework to execute the tests
-handle exception by using try catch block and print stack trace
-extends CucumberTestNgCucumberTest abstract class which help used testNg concept 
-add proper feature file path and step definition path in CucumberOptions annotation
-use dryRun,tags and monochrome options in CucumberOptions annotation as per requirement

