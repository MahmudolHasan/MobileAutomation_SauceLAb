package TestCases;

import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;


   @Test
    public void loginWithValidCredentials() throws InterruptedException {
        loginPage = new LoginPage ();
        loginPage.inputCredentials ("standard_user","secret_sauce");
        loginPage.login ();
    }



}
