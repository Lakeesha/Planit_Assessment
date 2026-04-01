package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage
{
    public WebDriver driver;
    public By contactPageLink = By.linkText("Contact");
    public By shopPageLink = By.linkText("Shop");
    public By cartPageLink = By.partialLinkText("Cart");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void navigateToContactPage()
    {
        driver.findElement(contactPageLink).click();
    }

    public void navigateToShopPage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(shopPageLink));
        driver.findElement(shopPageLink).click();
    }

    public void navigateToCartPage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(shopPageLink));
        driver.findElement(cartPageLink).click();
    }
}

