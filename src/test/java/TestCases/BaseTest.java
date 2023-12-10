package TestCases;

import DriverFactory.DriverSetup;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.AppiumServer;

public class BaseTest {
    //private static URL url ;
    static AndroidDriver driver;

    //static AppiumServer server;
    private static void startAppiumServer(){

        AppiumServer.start ();
    }
    @BeforeSuite
    public static synchronized void openServer (){
        DesiredCapabilities caps = new DesiredCapabilities ();
        caps.setCapability ("platformName", "android");
        //caps.setCapability ("enforceXPath1", true);
        caps.setCapability ("automationName", "uiAutomator2");
        caps.setCapability ("deviceName", "local");
        caps.setCapability ("udid", "emulator-5554");
        caps.setCapability ("appPackage", "com.swaglabsmobileapp");
        caps.setCapability ("appActivity", "com.swaglabsmobileapp.MainActivity");


        try{
            startAppiumServer ();
           driver = DriverSetup.createDriver (AppiumServer.getUrl (),caps);
            DriverSetup.setLocalDriver (driver);
        } catch (Exception e) {
            System.out.println ("Problem in BeforeSuite!");
            throw new RuntimeException (e);
        }

    }

    @AfterSuite
    public static synchronized void teardown(){
        if(driver != null)
        {
           driver.quit ();
            AppiumServer.stop ();
        }

    }
}
