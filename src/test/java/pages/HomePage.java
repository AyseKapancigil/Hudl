package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage(){PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptAllCookiesButton;

    @FindBy(xpath = "//a[@class='skip-nav']")
    public WebElement skipToMainContent;

    @FindBy(xpath = "//div[@class='outer']")
    public WebElement outer;

    @FindBy(xpath = "/html/body/noscript[1]/text()")
    public WebElement iframe;


    @FindBy(xpath = "//a[@class='mainnav__btn mainnav__btn--primary']")
    public WebElement homeLoginButton;


  @FindBy(xpath = "//h1")
  public WebElement headers;

  @FindBy(xpath = "//p[@class='uni-text']")
  public WebElement errorMessage;







}


