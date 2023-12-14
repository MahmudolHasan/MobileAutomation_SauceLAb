package Pages;

import org.openqa.selenium.By;
import utilities.util;

public class Checkout extends util {

    By txtInput_firstName = By.xpath ("//android.widget.EditText[@content-desc=\"test-First Name\"]");
    By txtInput_lastName = By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]");
    By txtInput_zipCode = By.xpath ("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]");
    By transitToOverview = By.xpath ("//android.widget.TextView[@text=\"CONTINUE\"]");

    public boolean CheckOutverify() throws InterruptedException {
        return elementIsDisplayed (txtInput_firstName);
    }
    public overview submit(String fname,String lname,String zip) throws InterruptedException {
        txt_input (txtInput_firstName,fname);
        txt_input (txtInput_lastName,lname);
        txt_input (txtInput_zipCode,zip);
        clickOnEle (transitToOverview);
        return new overview ();
    }
}

