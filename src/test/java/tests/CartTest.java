package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();

        Assert.assertEquals(
                inventoryPage.getCartCount(),
                "1",
                "Количество товаров в корзине должно быть 1"
        );

        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(
                cartPage.getProductName(),
                "Sauce Labs Backpack",
                "В корзине должен находиться Sauce Labs Backpack"
        );

        Assert.assertEquals(
                cartPage.getProductPrice(),
                "$29.99",
                "Цена Sauce Labs Backpack должна быть $29.99"
        );
    }
}