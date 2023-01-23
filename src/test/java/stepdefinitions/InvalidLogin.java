package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.LoginPage;
import pojo.LogInPojo;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class InvalidLogin {

    HomePage homePage;
    Actions actions= new Actions(Driver.getDriver());
    LogInPojo logInPojo;
    Faker faker =new Faker();
    LoginPage loginPage;
    @Given("users navigate the login page")
    public void users_navigate_the_login_page() {
        homePage=new HomePage();
        ReusableMethods.waitForClickablility(homePage.acceptAllCookiesButton,5);
        JSUtils.clickElementByJS(homePage.acceptAllCookiesButton);

        actions.doubleClick(homePage.headers).build().perform();

        homePage.homeLoginButton.click();



    }
    @When("users enter invalid {string} and {string} in search box")
    public void users_enter_invalid_and_in_search_box(String email, String password) {


        loginPage=new LoginPage();
      // email=faker.internet().emailAddress();
    // logInPojo.setEmail(email);
       loginPage.emailBox.sendKeys(email);
        ReusableMethods.waitFor(3);
     // password=faker.internet().password();
       //logInPojo.setPassword(password);
     loginPage.passwordBox.sendKeys(password);
        loginPage.loginButton2.click();




    }
    @Then("verifies {string} message displayed")
    public void verifies_message_displayed(String message) {

        Assert.assertFalse(homePage.errorMessage.isDisplayed());

    }
}
