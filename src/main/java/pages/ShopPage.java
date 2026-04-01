package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage
{
    private WebDriver driver;

    public ShopPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void buyStuffedFrog(int quantity)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h4[contains(text(),'Stuffed Frog')]/following-sibling::p/a")));
        By addButton = By.xpath("//h4[text()='Stuffed Frog']/following-sibling::p/a");
        for(int i = 0; i < quantity; i++)
        {
            driver.findElement(addButton).click();
        }
    }

    public void buyFluffyBear(int quantity)
    {
        By addButton = By.xpath("//h4[text()='Fluffy Bunny']/following-sibling::p/a");
        for(int i = 0; i < quantity; i++)
        {
            driver.findElement(addButton).click();
        }
    }

    public void buyValentineBear(int quantity)
    {
        By addButton = By.xpath("//h4[text()='Valentine Bear']/following-sibling::p/a");
        for(int i = 0; i < quantity; i++)
        {
            driver.findElement(addButton).click();
        }
    }
}
