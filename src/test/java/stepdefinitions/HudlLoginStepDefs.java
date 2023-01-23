package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.LoginPage;
import pages.UserAccountPage;
import pojo.LogInPojo;
import utilities.*;

public class HudlLoginStepDefs {

   HomePage homePage;
   LoginPage loginPage;
   UserAccountPage userAccountPage;
    Actions actions =new Actions(Driver.getDriver());
    LogInPojo logInPojo = new LogInPojo();

    @Given("user opens the URL {string}")
    public void user_opens_the_url(String string)   {
       homePage = new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));


    }
    @When("user navigate the login page")
    public void user_navigate_the_login_page()  {
      ReusableMethods.waitForClickablility(homePage.acceptAllCookiesButton,5);
      JSUtils.clickElementByJS(homePage.acceptAllCookiesButton);

        actions.doubleClick(homePage.headers).build().perform();
         //ReusableMethods.waitForClickablility(homePage.skipToMainContent,20);
        //JSUtils.clickElementByJS(homePage.skipToMainContent);

  //Driver.getDriver().switchTo().frame(homePage.iframe);

      homePage.homeLoginButton.click();
    }
    @When("user enters email as {string} and password as {string} and click on login button")
    public void user_enters_email_as_and_password_as_and_click_on_login_button(String email, String password) {

     loginPage=new LoginPage();
     loginPage.emailBox.sendKeys(email);
     loginPage.passwordBox.sendKeys(password);

     logInPojo.setEmail(email);
     logInPojo.setPassword(password);



    }
    @Then("verify the login is successful")
    public void verify_the_login_is_successful() {

  loginPage.loginButton2.click();


  userAccountPage=new UserAccountPage();

  ReusableMethods.waitForVisibility(userAccountPage.yourAccountText,5);
  String yourAccountText =userAccountPage.yourAccountText.getText();
  Assert.assertEquals("Your Account",yourAccountText);
    }
    @Then("capture the screenshot")
    public void capture_the_screenshot() {

    }
    @Then("close the application")
    public void close_the_application() {
       userAccountPage.yourAccountText.click();

        TxtWriter.saveData(logInPojo);

      userAccountPage.logOutButton.click();
        Driver.closeDriver();

    }

}
