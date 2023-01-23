# Hudl
My framework is basically established on "Maven-Selenium-Cucumber-JUnit" test automation tools. 
I have developed my framework based on Page Object Model and Java is my programming language. 
My Framework is a hybrid framework which supports both BDD and Data Driven Testing. I use Scenerio Outline in order to implment Data Driven Testing.

Initially I use pom.xml file to centralize my dependencies and configure necessary plugins and profiles.
I also have configuration.properties and environment.properties files.
In those files I store some common data and environment description such as browser,credentials,URL for UI testing.
I could also put my BaseURL,apiKeys,bearer usename and password for API Testing and database connectivity credentials and EC2 device informaion for DataBase 
Testing.

I keep all my Feature files under the Resources directory.In feature files I have scenarios or scenario outlines in which I define my test stepsby using Gherkin 
language key words such as Given,When,Then<And.
I also use tags in order to generate my Smoke and Regression suites. 
After declaration of the application behaviours in my feature file,I create a Java class in StepDefinitions package which corresponds a single feature file.
In each ste definition class,I create identical steps in order to implement assertions.

Then I go to Pages package.As I mentioned,I implement POM in my framework in order to prevent code redundancy,make the codes reusable and easy to maintain.
I also implement all sort of Object Oriented Programming Concepts in my framework such as Encapsulation in POJO classes,inheritance and abstraction between 
BasePage and other page classes and polimorphism almost everywhere.In each page class,I implement Page Factory Design Pattern 
by using PageFactory.initElements(driver,this) method.By doing so, I locate all the web elements by using @FindBy annotation instead of 
using findElement() method.
After locating all necessary WebElements,I call them from related method in the same page class and I return only the actual result for each functionality.

After completing my pages class,I come into corresponding step definition class again and create objects from that related page class.
By using these objetcs,I can invoke all the related methods in each step and 
I can compare the actual result which comes from page class and the expected result which mopstly comes from feature file.

I also have Hooks Class ,I use @Before /@After annotations to gather all common setup and teardown requirements for my step definitions 
such as launching browser,implicit wait,setting baseURI for API ,creating DAtaBase connection,taking screentshot for failed scenarios,
closing the driver or databese connection and logging issues.

After finishing all the setup,now I am ready to run my scenarios.I use @RunWith(Cucumber.class) annotation to run my test cases with help of JUnit.
I have a bunch of Cucumber options in runner class such as fetures,glue,plugin,monochrome,dryRun and tags.
I initially execute test cases as dryRun to make sure that feature files and stepDefinitions are mapping the I execute my test cases as dryRun is false.

I would also have DB Utilities,API Utilities,ExcelReader If I need them and of course my Driver class in utilities package.
In my Driver class I prefer to use Singleton Design Pattern which contains a private WebDriver object and private constructor and also public getter method.
By doing so,I ensure that there is going to be only a single WebDriver object throughout the framwork and none of the class will be able to
create another WebDriver object.

My framework produces"default cucumber reporst" which is not taht much fancy.Because of that I also use very detailed "Cucumber HTML Reporst" which generates
bar charts,pie charts and tables with the help of cucember reports plugin
in my pom.xml file.

I also got my TxtWriter class under my utilities package which generates RegistrationData txt file under testdata.
Everytime I run my feature files,the relavant data generates there to help me for validation when I need it.

I achieve continuous integration and schedule my test executions by using Jenkins.I have regression and smoke test jobs on Jenkins which are integrated
with my framework by using GitHub URL.(I segregate my regression and smoke test execution by using 
different maven goals on Jenkins such as <verify-Dcucmber.options="--tags@smoke">) taht is pretty much about my framework.


