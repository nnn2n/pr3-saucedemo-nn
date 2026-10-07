package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

@Epic("SauceDemo UI Testing")
@Feature("Корзина")
public class CartTest extends BaseTest {

    @Test
    @Story("Добавление товара в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Anastasia")
    public void addProductToCartTest() {

        Allure.step("Авторизоваться стандартным пользователем");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Добавить Sauce Labs Backpack в корзину");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();

        Allure.step("Открыть корзину");

        inventoryPage.openCart();

        Allure.step("Проверить наличие товара в корзине");

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(
                cartPage.getProductName().contains("Sauce Labs Backpack"),
                "В корзине должен отображаться Sauce Labs Backpack"
        );
    }
}