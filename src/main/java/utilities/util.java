package utilities;

import DriverFactory.DriverSetup;
import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public String getEleText(By locator) throws InterruptedException {
        String text = null;
        try{
            text = findElement (locator).getText ();
        }catch(TimeoutException e){
            System.out.println ("No text Founded!Returned Null value!");
        }
        return text;
    }

    private void waitForElement (By locator) {
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (25));
        wait.until (ExpectedConditions.visibilityOfElementLocated (locator));
    }

    public void scroll (double scrollSpace, String direction) {
        Duration dur = Duration.ofMillis (400);
        Dimension size = driver.manage ().window ().getSize ();
        PageLoadTimeOut (25);
        if (scrollSpace <= 0 || scrollSpace >= 1) throw new Error ("scrollSpace should be between 0 to 1 exclusive!");
        System.out.println ("Size: " + size);
        Point midPoint = new Point (size.getWidth () / 2, size.getHeight () / 2);
        System.out.println ("MidPoint: " + midPoint);
        if (direction.equalsIgnoreCase ("down")) {
            Point upPoint = new Point (midPoint.x, (int) (midPoint.y - (midPoint.y) * scrollSpace));
            swipe (new Point (midPoint.x, midPoint.y), new Point (upPoint.x, upPoint.y), dur);
        } else if (direction.equalsIgnoreCase ("up")) {
            Point downPoint = new Point (midPoint.x, (int) (midPoint.y + (midPoint.y) * scrollSpace));
            swipe (new Point (midPoint.x, midPoint.y), new Point (downPoint.x, downPoint.y), dur);
        } else if (direction.equalsIgnoreCase ("left")) {
            Point downPoint = new Point ((int) (midPoint.x + (midPoint.x) * scrollSpace), midPoint.y);
            swipe (new Point (midPoint.x, midPoint.y), new Point (downPoint.x, downPoint.y), dur);
        } else if (direction.equalsIgnoreCase ("right")) {
            Point downPoint = new Point ((int) (midPoint.x - (midPoint.x) * scrollSpace), midPoint.y);
            swipe (new Point (midPoint.x, midPoint.y), new Point (downPoint.x, downPoint.y), dur);
        }
    }
    public void scrollToTop(){
        Map<String, Point> pointMap= getPoints ();
        swipe (pointMap.get ("upPoint"),pointMap.get ("downPoint"),Duration.ofMillis (100));

    }
    public void scrollToBottom(){
        Map<String, Point> pointMap= getPoints ();
        swipe (pointMap.get ("downPoint"),pointMap.get ("upPoint"),Duration.ofMillis (150));
//        driver.findElement (new AppiumBy.ByAndroidUIAutomator (
//                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(20))"


    }
    public void swipe (Point start, Point end, Duration duration) {
        //PageLoadTimeOut (25);
        PointerInput finger1 = new PointerInput (PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence (finger1, 0);
        swipe.addAction (finger1.createPointerMove (Duration.ZERO, PointerInput.Origin.viewport (), start.x, start.y));
        swipe.addAction (finger1.createPointerDown (PointerInput.MouseButton.LEFT.asArg ()));
        swipe.addAction (new Pause (finger1, Duration.ofMillis (100)));
        swipe.addAction (finger1.createPointerMove (duration, PointerInput.Origin.viewport (), end.x, end.y));
        swipe.addAction (finger1.createPointerUp (PointerInput.MouseButton.LEFT.asArg ()));


        driver.perform (ImmutableList.of (swipe));
    }

    public void scrollUntilVisible (String eleText, String direction) throws InterruptedException {
        driver.findElement (new AppiumBy.ByAndroidUIAutomator (
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + eleText + "\").instance(0))"
        ));
        scroll (.2, direction);

        Thread.sleep (200); //wait of 10 seconds

    }
    public static void takeScreenshot (Method method){
        TakesScreenshot takesScreenshot = (TakesScreenshot) getLocalDriver () ;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(
                System.getProperty("user.dir") + "/src/test/resources/failed_test_screenshots/" +System.currentTimeMillis ()
                        +"-"+method.getName ()+ ".png");

        try {
            FileHandler.copy(source, destination);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sortWords(String word01, String word02){
        if(word01.compareTo (word02) > 0){
            return word02;
        }
        return word01;
    }

    public boolean elementIsDisplayed(By locator) throws InterruptedException {
        return findElement (locator).isDisplayed ();
    }
    //////////////////////////////Private Functions//////////////////////////////////////
    private Map getPoints () {
        Dimension size = driver.manage ().window ().getSize ();
        Map<String, Point> pointMap = new HashMap<String, Point> ();
        pointMap.put ("upPoint", new Point (size.getWidth () / 2, (int) (size.getHeight () * .2)));
        pointMap.put ("downPoint", new Point (size.getWidth () / 2, (int) (size.getHeight () * .8)));
        pointMap.put ("rightPoint", new Point ((int) (size.getWidth () - size.getWidth () * .2), size.getHeight () / 2));
        pointMap.put ("leftPoint", new Point ((int) (size.getWidth () - size.getWidth () * .8), size.getHeight () / 2));
        return pointMap;
    }

}
