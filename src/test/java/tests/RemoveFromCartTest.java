package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

@Epic("SauceDemo UI Testing")
@Feature("Корзина")
public class RemoveFromCartTest extends BaseTest {

    @Test
    @Story("Удаление товара из корзины")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Anastasia")
    public void removeProductFromCartTest() {

        Allure.step("Авторизоваться стандартным пользователем");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Добавить Sauce Labs Backpack в корзину");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();

        Allure.step("Удалить товар из корзины");

        CartPage cartPage = new CartPage(driver);
        cartPage.removeBackpack();

        Allure.step("Проверить, что корзина пуста");

        Assert.assertTrue(
                cartPage.isCartEmpty(),
                "После удаления товара корзина должна быть пустой"
        );
    }
}