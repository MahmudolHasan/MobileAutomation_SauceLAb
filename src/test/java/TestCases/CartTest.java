package TestCases;

import Pages.Cart;
import Pages.Checkout;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    Cart cart;
    Checkout checkout;

    @BeforeMethod
    public void setupForCart () throws InterruptedException {
        loginPage =new LoginPage ();
        homePage = loginPage.doLogin ();
        homePage.addCartBikeLight ();
        cart = homePage.moveToCart ();
    }
    @Test
    public void moveToHomePage() throws InterruptedException {
        homePage=cart.continueShopping ();
        boolean actual =  homePage.verifyHomePage ();
        Assert.assertTrue (actual,"Landed somewhere else!");
    }

    @Test
    public void removeProduct() throws InterruptedException {
        boolean flag = cart.removeProductFromCart ("Light");
    }

    @Test
    public void moveToCheckout() throws InterruptedException {
        cart = new Cart ();
        checkout = cart.checkout ();
        Assert.assertTrue (checkout.CheckOutverify ());
    }
}
