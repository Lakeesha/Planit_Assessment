package tests;

import Constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.HomePage;
import pages.ShopPage;
import utils.DriverManager;

public class TestCase3
{
    private WebDriver driver;
    private String itemOne = "Stuffed Frog";
    private String itemTwo = "Fluffy Bunny";
    private String itemThree = "Valentine Bear";

    @BeforeMethod
    public void LoadBrowser()
    {
        driver = DriverManager.loadDriver();
        driver.get(Constants.home_page_url);
    }

    @Test
    public void testCartVerification()
    {
        SoftAssert softAssert = new SoftAssert();
        HomePage home = new HomePage(driver);
        home.navigateToShopPage();
        ShopPage shop = new ShopPage(driver);
        shop.buyStuffedFrog(2);
        shop.buyFluffyBear(5);
        shop.buyValentineBear(3);
        home.navigateToCartPage();
        CartPage cart = new CartPage(driver);
        double subTotalOfStuffedFrog = cart.getSubTotalOfProduct(itemOne);
        double subTotalOfFluffyBunny = cart.getSubTotalOfProduct(itemTwo);
        double subTotalOfValentineBear = cart.getSubTotalOfProduct(itemThree);
        softAssert.assertEquals(subTotalOfStuffedFrog, cart.getPriceOfProduct(itemOne)*2,"Mismatch in the subtotal price of the products");
        softAssert.assertEquals(subTotalOfFluffyBunny, cart.getPriceOfProduct(itemTwo)*5,"Mismatch in the subtotal price of the products");
        softAssert.assertEquals(subTotalOfValentineBear, cart.getPriceOfProduct(itemOne)*3,"Mismatch in the subtotal price of the products");
        double totalPrice = subTotalOfStuffedFrog + subTotalOfFluffyBunny + subTotalOfValentineBear;
        softAssert.assertEquals(cart.getTotalPriceOfProducts(),totalPrice,"Mismatch in the total price of the products");
        softAssert.assertAll();
    }

    @AfterMethod
    public void quitBrowser()
    {
        DriverManager.quitDriver();
    }

}
