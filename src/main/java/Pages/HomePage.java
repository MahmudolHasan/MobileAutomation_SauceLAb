package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import DriverFactory.DriverSetup;
import utilities.util;

public class HomePage extends util {

//    public HomePage () {
//        PageFactory.initElements (getLocalDriver (),this);
//
//    }
  //  @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
   By userNameInput = By.xpath
        ("//android.widget.EditText[@content-desc=\"test-Username\"]");

    //@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    By passwordInput = By.xpath
            ("//android.widget.EditText[@content-desc=\"test-Password\"]");

    //@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    By letsShopBtn = By.xpath
            ("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");

    public void inputCredentials(String username, String password) throws InterruptedException {
        txt_input (userNameInput,username);
        txt_input (passwordInput,password);
    }

    public void login() throws InterruptedException {

        clickOnEle (letsShopBtn);
        threadSleep (5);
    }


}
