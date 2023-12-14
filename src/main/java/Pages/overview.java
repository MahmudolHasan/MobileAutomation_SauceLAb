package Pages;
import org.openqa.selenium.By;
import utilities.util;

public class overview extends util {

    By btn_finish = By.xpath("//android.widget.TextView[@text=\"FINISH\"]");

    public orderConfirmation completeOrder() throws InterruptedException {
        clickOnEle (btn_finish);
        return new orderConfirmation ();
    }

}
