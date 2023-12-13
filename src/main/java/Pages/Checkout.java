package Pages;

import org.openqa.selenium.By;
import utilities.util;

public class Checkout extends util {

    By txtInput_firstName = By.id ("test-First Name");
    By txtInput_lastName = By.id ("test-Last Name");
    By txtInput_zipCode = By.id ("test-Zip/Postal Code");
    By transitToOverview = By.xpath ("//android.widget.TextView[@text=\"CONTINUE\"]");

    public overview submit() throws InterruptedException {
        txt_input (txtInput_firstName,"Keyeser");
        txt_input (txtInput_lastName,"Soze");
        txt_input (txtInput_zipCode,"A105");
        clickOnEle (transitToOverview);
        return new overview ();
    }
}
