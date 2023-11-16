package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utilities.DriverSetup.getLocalDriver;
public class HomePage {

//    public HomePage () {
//        PageFactory.initElements (getLocalDriver (),this);
//
//    }
  //  @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    WebElement userNameInput = getLocalDriver ().findElement (
            By.xpath ("//android.widget.EditText[@content-desc=\"test-Username\"]"));

    //@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    WebElement passwordInput = getLocalDriver ().findElement (
            By.xpath ("//android.widget.EditText[@content-desc=\\\"test-Password\\\"]"));

    //@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    WebElement letsShopBtn = getLocalDriver ().findElement (
            By.xpath ("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]"));

    public void inputCredentials(String username, String password){
        try{
            System.out.println ("Visibility: "+userNameInput.isDisplayed ());
        }catch(Exception e)
        {
            System.out.println ("Exception caught!");
            e.printStackTrace ();
        }
        userNameInput.clear ();
        userNameInput.sendKeys (username);

        passwordInput.clear ();
        passwordInput.sendKeys (password);
    }

    public void login(){
        letsShopBtn.click ();
    }


}
