package TestCases;

import Pages.HomePage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import utilities.DriverSetup;

import java.sql.SQLOutput;
import java.time.Duration;

public class HomePageTest extends DriverSetup {
    HomePage homePage ;


   // @Test
    public void loginWithValidCredentials(){
        homePage = new HomePage ();
        homePage.inputCredentials ("standard_user","secret_sauce");
        homePage.login ();
    }



}
