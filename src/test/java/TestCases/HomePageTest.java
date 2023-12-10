package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void validLogin() throws InterruptedException {
        loginPage = new LoginPage ();
        homePage = loginPage.doLogin ();
    }
    @Test
    public void scrollTest() throws InterruptedException {
        homePage.scrollBottomTop ();
    }
    @Test
    public void findProduct(){

    }
}
