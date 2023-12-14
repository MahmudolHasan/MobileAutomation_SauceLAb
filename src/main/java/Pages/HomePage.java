package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.testng.Assert;
import utilities.util;

public class HomePage extends util {

    /////////////////////////////////////////////////**LOCATORS)09090000000000000000000000000000000000000000009009///////////////////////////////////////////////////////////
    By btn_toggleView = By.xpath ("//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView");

    By btn_addProductText = By.xpath ("//android.widget.TextView[1]");
    By btn_sortingBy = By.xpath ("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");
    By sortingWindow = By.xpath ("//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[1]");
    By sortByNameAtoZ = By.xpath ("//android.widget.TextView[@text=\"Name (A to Z)\"]");
    By sortByNameZtoA = By.xpath ("//android.widget.TextView[@text=\"Name (Z to A)\"]");
    By sortByPriceLtoH = By.xpath ("//android.widget.TextView[@text=\"Price (low to high)\"]");
    By sortByPriceHtoL = By.xpath ("//android.widget.TextView[@text=\"Price (high to low)\"]");
    By cancelSortingWindow = By.xpath ("//android.widget.TextView[@text=\"Cancel\"]");

    By firstProduct = By.xpath ("((//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]//android.widget.TextView)[2]");
    By secondProduct = By.xpath ("((//android.view.ViewGroup[@content-desc=\"test-Item\"])[2]//android.widget.TextView)[2]");
    By firstProductPrice = By.xpath
            ("((//android.view.ViewGroup[@content-desc='test-Item'])[1]//android.widget.TextView)[3]");
    By secondProductPrice = By.xpath
            ("((//android.view.ViewGroup[@content-desc='test-Item'])[2]//android.widget.TextView)[3]");

    By btn_cart = By.xpath ("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup");
    By addCart_BikeLight = By.xpath ("(//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Bike Light\"])/following-sibling::android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]/android.widget.TextView[@text=\"ADD TO CART\"]");
    By removeCart_BikeLight = By.xpath ("(//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Bike Light\"])/following-sibling::android.view.ViewGroup[@content-desc=\"test-REMOVE\"]/android.widget.TextView[@text=\"REMOVE\"]");
    By cartProducts = By.xpath ("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup//android.widget.TextView");



    public void scrollBottomTop () throws InterruptedException {


        scrollToBottom ();
        threadSleep (5);
        System.out.println ("Scrolled Bottom");

        scrollToTop ();
        System.out.println ("Scrolled Top");
        threadSleep (3);

    }

    public boolean verifyHomePage() throws InterruptedException {
        return (elementIsDisplayed (btn_toggleView));
    }

    public String toggleView () throws InterruptedException {
        clickOnEle (btn_toggleView);
        return getEleText (btn_addProductText);
    }

    public boolean selectSortingMethod (String sortBy) throws InterruptedException {
        clickOnEle (btn_sortingBy);
        if (findElement (sortingWindow).isDisplayed ()) {
            if (sortBy.equalsIgnoreCase ("priceLowHigh")) {
                clickOnEle (sortByPriceLtoH);
                return (Double.parseDouble (getEleText (firstProductPrice)) < Double.parseDouble (getEleText (secondProductPrice)));
            } else if (sortBy.equalsIgnoreCase ("priceHighLow")) {
                clickOnEle (sortByPriceHtoL);
                return (Double.parseDouble (getEleText (firstProductPrice)) > Double.parseDouble (getEleText (secondProductPrice)));
            } else if (sortBy.equalsIgnoreCase ("NameAZ")) {
                clickOnEle (sortByNameAtoZ);
                String word = sortWords (getEleText (firstProduct), getEleText (secondProduct));
                return word.equals (getEleText (firstProduct));
            } else if (sortBy.equalsIgnoreCase ("NameZA")) {
                clickOnEle (sortByNameZtoA);
                String word = sortWords (getEleText (firstProduct), getEleText (secondProduct));
                return word.equals (getEleText (secondProduct));
            } else {
                throw new IllegalArgumentException ("Please Enter a valid Option! (priceLowHigh,priceHighLow,NameAZ,NameZA");
            }
        } else {
            throw new NotFoundException ("Sorting Window doesn't exist!");
        }
    }

    public int addCartBikeLight () throws InterruptedException {
        clickOnEle (addCart_BikeLight);
        return Integer.parseInt ((getEleText (cartProducts)));
    }
    public int removeBikeLight() throws InterruptedException {
        clickOnEle (removeCart_BikeLight);
        String text = getEleText (cartProducts);
        if(text==null) return -1;
        return Integer.parseInt (text);
    }
    public Cart moveToCart() throws InterruptedException {
        clickOnEle (btn_cart);
        return new Cart ();
    }

}


