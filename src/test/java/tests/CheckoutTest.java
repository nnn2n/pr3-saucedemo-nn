package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);

        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.fillCustomerData(
                "Anastasia",
                "Nikolaeva",
                "12345"
        );

        checkoutPage.clickContinue();

        Assert.assertEquals(
                checkoutPage.getProductName(),
                "Sauce Labs Backpack",
                "На странице Overview должен отображаться Sauce Labs Backpack"
        );

        Assert.assertTrue(
                checkoutPage.getTotal().contains("Total:"),
                "На странице Overview должен отображаться итоговая сумма"
        );

        checkoutPage.clickFinish();

        Assert.assertEquals(
                checkoutPage.getCompleteMessage(),
                "Thank you for your order!",
                "После завершения заказа должно появиться сообщение об успешном оформлении"
        );
    }
}