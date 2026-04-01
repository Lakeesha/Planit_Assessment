package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage
{
    public WebDriver driver;
    public By contactPageLink = By.linkText("Contact");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void navigateToContactPage()
    {
        driver.findElement(contactPageLink).click();
    }

    public void quitPage()
    {
        driver.quit();
    }
}
