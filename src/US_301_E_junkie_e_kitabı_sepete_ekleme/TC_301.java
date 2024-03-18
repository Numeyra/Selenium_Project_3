package US_301_E_junkie_e_kitabı_sepete_ekleme;
import Utlity.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC_301 extends BaseDriver {

    @Test
    public void testEJunkieDemo() {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='view_product')]"));
        addToCartButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Apply")));

        WebElement cartItem = driver.findElement(By.xpath("//div[@class='ion-ios-cart']"));
        Assert.assertTrue(cartItem.getText().contains("Demo E-Kitabı"));

        WebElement promoCodeButton = driver.findElement(By.xpath("//a[contains(text(),'Promosyon Kodu Ekle')]"));
        promoCodeButton.click();

        WebElement promoCodeInput = driver.findElement(By.xpath("//input[@name='coupon_code']"));
        promoCodeInput.sendKeys("InvalidCode12345");

        WebElement applyButton = driver.findElement(By.xpath("//input[@value='Apply']"));
        applyButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Invalid promo code')]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

}





























