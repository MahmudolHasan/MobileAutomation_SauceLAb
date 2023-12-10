package utilities;

import DriverFactory.DriverSetup;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class util extends DriverSetup {

    AndroidDriver driver = getLocalDriver ();

    public WebElement findElement (By locator) throws InterruptedException {
        waitForElement (locator);
        return driver.findElement (locator);
    }

    public void threadSleep (int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep (seconds);
    }

    public void PageLoadTimeOut (int seconds) {
        driver.manage ().timeouts ().pageLoadTimeout (Duration.ofSeconds (seconds));
    }

    public void txt_input (By locator, String input) throws InterruptedException {
        clearInPutField (locator);
        findElement (locator).sendKeys (input);
    }

    public void clearInPutField (By locator) throws InterruptedException {
        findElement (locator).clear ();
    }

    public void clickOnEle (By locator) throws InterruptedException {
        findElement (locator).click ();
    }

    private void waitForElement (By locator) {
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (25));
        wait.until (ExpectedConditions.visibilityOfElementLocated (locator));
    }
}
