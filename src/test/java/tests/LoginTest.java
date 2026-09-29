package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/inventory.html"));

        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/inventory.html"),
                "Ожидался URL /inventory.html, но получен: " + driver.getCurrentUrl()
        );

        Assert.assertEquals(
                inventoryPage.getProductsTitle(),
                "Products",
                "Ожидался заголовок Products"
        );
    }

    @Test
    public void lockedOutUserLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        String errorMessage = loginPage.getErrorMessage();

        Assert.assertTrue(
                errorMessage.contains("Epic sadface"),
                "Ожидалось сообщение об ошибке, но получено: " + errorMessage
        );
    }
}