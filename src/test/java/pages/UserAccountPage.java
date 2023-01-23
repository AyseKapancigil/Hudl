package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserAccountPage {

  public UserAccountPage(){ PageFactory.initElements(Driver.getDriver(),this);

  }
  @FindBy(xpath ="//span[@class='no-localization-available']")
  public WebElement yourAccountText;

  @FindBy(xpath = "//span[@data-reactid='34']")
  public WebElement logOutButton;

}
