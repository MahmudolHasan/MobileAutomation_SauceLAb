package TestCases;

import Pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage ;


   @Test
    public void loginWithValidCredentials() throws InterruptedException {
        homePage = new HomePage ();
        homePage.inputCredentials ("standard_user","secret_sauce");
        homePage.login ();
    }



}
