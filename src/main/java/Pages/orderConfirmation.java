package Pages;

import org.openqa.selenium.By;
import utilities.util;

public class orderConfirmation extends util {

    By thankYouMessage = By.xpath("//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]");
    By completetionLogo = By.xpath ("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.ImageView");
    By btn_backToHome = By.xpath ("//android.widget.TextView[@text=\"BACK HOME\"]");

    public boolean completetionMessage() throws InterruptedException {
        return (elementIsDisplayed (thankYouMessage) && elementIsDisplayed (completetionLogo));
    }

}
