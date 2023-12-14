package TestCases;

import DriverFactory.DriverSetup;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.AppiumServer;

import java.net.URL;

public class BaseTest {
    //private static URL url ;
    static AndroidDriver driver;


    //static AppiumServer server;
    private static void startAppiumServer () {

        AppiumServer.start ();
    }

    @BeforeMethod
    public static synchronized void openServer () {
        DesiredCapabilities caps = new DesiredCapabilities ();
        caps.setCapability ("platformName", "android");
        //caps.setCapability ("enforceXPath1", true);
        caps.setCapability ("automationName", "uiAutomator2");
        caps.setCapability ("deviceName", "local");
        caps.setCapability ("udid", "emulator-5554");
        caps.setCapability ("appPackage", "com.swaglabsmobileapp");
        caps.setCapability ("appActivity", "com.swaglabsmobileapp.MainActivity");


        try {
            startAppiumServer ();
            System.out.println ("Server: " + AppiumServer.getUrl ());
            driver = DriverSetup.createDriver (AppiumServer.getUrl (), caps);
            //driver = DriverSetup.createDriver (new URL (  "http://192.168.100.4:4723/"), caps);
            DriverSetup.setLocalDriver (driver);
        } catch (Exception e) {
            System.out.println ("Problem in BeforeSuite!");
            throw new RuntimeException (e);
        }

    }


    @AfterMethod
    public static synchronized void teardown () {
        if (driver != null) {
            driver.quit ();
            AppiumServer.stop ();
        }

    }
}
