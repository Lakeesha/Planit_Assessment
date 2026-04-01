package tests;

import Constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ContactPage;
import pages.HomePage;
import utils.DriverManager;

public class TestCase2 {
    private WebDriver driver;
    private String forename = "John";

    @BeforeMethod
    public void LoadBrowser() {
        driver = DriverManager.loadDriver();
        driver.get(Constants.home_page_url);
    }

    @Test(invocationCount = 5)
    public void testSubmissionPageValidations()
    {
        SoftAssert softAssert = new SoftAssert();
        HomePage home = new HomePage(driver);
        home.navigateToContactPage();
        ContactPage contact = new ContactPage(driver);
        contact.enterMandataryDetails(forename, forename + "@gmail.com", forename + " user message complete");
        contact.clickSubmit();
        softAssert.assertEquals(contact.isSuccessMessageIsDisplayed(), "Thanks " + forename + ", we appreciate your feedback.", "Invalid error message is displayed for the message");
        softAssert.assertAll();
    }

    @AfterMethod
    public void quitBrowser()
    {
        DriverManager.quitDriver();
    }
}
