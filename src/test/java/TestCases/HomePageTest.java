package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void validLogin () throws InterruptedException {
        loginPage = new LoginPage ();
        homePage = loginPage.doLogin ();
    }

    @Test(priority = 0)
    public void scrollTest () throws InterruptedException {
        homePage.scrollBottomTop ();
    }

    @Test(priority = 1)
    public void addToCart_BikeLight () throws InterruptedException {
        int cartProductNumber = homePage.addCartBikeLight ();
        Thread.sleep (2);
        Assert.assertEquals (cartProductNumber, 1, "No products added to cart!");

    }

    @Test(priority = 2)
    public void removeFromCart_BikeLight () throws InterruptedException {
        addToCart_BikeLight ();
        int actualProductNumber = homePage.removeBikeLight ();
        Assert.assertEquals (actualProductNumber, -1, "No product removed from cart!");

    }


}

