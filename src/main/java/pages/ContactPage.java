package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage
{
    private WebDriver driver;
    private By forenameField = By.id("forename");
    private By emailField = By.id("email");
    private By messageField = By.id("message");
    private By submitButton = By.linkText("Submit");
    private By forenameError = By.id("forename-err");
    private By emailError = By.id("email-err");
    private By messageError = By.id("message-err");
    private By successMessage = By.xpath("//div[@class='alert alert-success']");
    private By backbutton = By.linkText("« Back");

    public ContactPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void enterMandataryDetails(String forename, String email, String message)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(forenameField));
        driver.findElement(forenameField).sendKeys(forename);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickSubmit()
    {
        driver.findElement(submitButton).click();
    }

    public String isForeNameErrorDisplayedForNullValue()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(forenameError));
       return driver.findElement(forenameError).getText();
    }

    public String isEmailErrorDisplayedForNullValue()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailError));
        return driver.findElement(emailError).getText();
    }

    public String isMessageErrorDisplayedForNullValue()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageError));
        return driver.findElement(messageError).getText();
    }

    public boolean isSuccessMessageIsDisplayed()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(backbutton));
        return driver.findElement(successMessage).isDisplayed();
    }

}
