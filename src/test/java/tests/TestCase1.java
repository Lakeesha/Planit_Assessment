package tests;

import Constants.Constants;
import Constants.Messages;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ContactPage;
import pages.HomePage;
import utils.DriverManager;

public class TestCase1
{
    private WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        driver = DriverManager.loadDriver();
        driver.get(Constants.home_page_url);
    }

    @Test
    public void testContactPageValidations()
    {
        SoftAssert softAssert = new SoftAssert();
        HomePage home = new HomePage(driver);
        home.navigateToContactPage();
        ContactPage contact = new ContactPage(driver);
        contact.enterMandataryDetails("","","");
        contact.clickSubmit();
        softAssert.assertEquals(contact.isForeNameErrorDisplayedForNullValue(),Messages.forenameRequiredErrorMessage,"Invalid error message is displayed for the Forename");
        softAssert.assertEquals(contact.isEmailErrorDisplayedForNullValue(),Messages.emailRequiredErrorMessage,"Invalid error message is displayed for the email");
        softAssert.assertEquals(contact.isMessageErrorDisplayedForNullValue(),Messages.messageRequiredErrorMessage,"Invalid error message is displayed for the message");
        contact.clearTheFields();
        contact.enterMandataryDetails("test","test_user@gmail.com","test user message");
        softAssert.assertAll();

    }
}
