package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import utilities.util;

public class Cart extends util {
    By btn_continueShopping = By.xpath ("//android.widget.TextView[@text=\"CONTINUE SHOPPING\"]");
    By btn_checkOut = By.xpath ("//android.widget.TextView[@text=\"CHECKOUT\"]");
    By removeProductByName;

    public HomePage continueShopping () throws InterruptedException {
        if(! elementIsDisplayed (btn_continueShopping))
            scrollUntilVisible ("CONTINUE SHOPPING", "down");
        threadSleep (2);
        clickOnEle (btn_continueShopping);
        return new HomePage ();
    }

    public Checkout checkout () throws InterruptedException {
        if(! elementIsDisplayed (btn_checkOut)) {
            scrollUntilVisible ("CHECKOUT", "down");
        }
        clickOnEle (btn_checkOut);
        return new Checkout ();
    }


    public boolean removeProductFromCart (String name) throws InterruptedException {
        String xpath = "//android.widget.TextView[contains(@text,'" + name + "')]/parent::android.view.ViewGroup[@content-desc='test-Description']/following-sibling::android.view.ViewGroup[@content-desc='test-Price']/descendant::android.widget.TextView[@text='REMOVE']";
        this.removeProductByName = By.xpath (xpath);
        clickOnEle (removeProductByName);
        try{
            return elementIsDisplayed (removeProductByName);
        }
        catch(TimeoutException e){
            return false;
        }
    }




}
