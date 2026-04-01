package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage
{
    private WebDriver driver;

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public double getSubTotalOfProduct(String productName)
    {
        String product = "//td[contains(text(),'"+productName+"')]/following-sibling::td[3]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(product)));
        String productText = driver.findElement(By.xpath(product)).getText().trim();
        return Double.parseDouble(productText.replace("$",""));
    }

    public double getPriceOfProduct(String productName)
    {
        String product = "//td[contains(text(),'"+productName+"')]/following-sibling::td[1]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(product)));
        String productText = driver.findElement(By.xpath(product)).getText().trim();
        return Double.parseDouble(productText.replace("$",""));
    }

    public double getTotalPriceOfProducts()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//strong[contains(., 'Total:')]")));
        String productText = driver.findElement(By.xpath("//strong[contains(., 'Total:')]")).getText().trim();
        return Double.parseDouble(productText.replace("Total:",""));
    }
}
