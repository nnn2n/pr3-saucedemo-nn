package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

@Epic("SauceDemo UI Testing")
@Feature("Оформление заказа")
public class CheckoutTest extends BaseTest {

    @Test
    @Story("Оформление заказа")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Anastasia")
    public void checkoutTest() {

        Allure.step("Авторизоваться стандартным пользователем");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Добавить товар в корзину");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();

        Allure.step("Перейти к оформлению заказа");

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        Allure.step("Заполнить данные покупателя");

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.fillCustomerData(
                "Anastasia",
                "Nikolaeva",
                "12345"
        );

        Allure.step("Перейти к проверке заказа");

        checkoutPage.clickContinue();

        Allure.step("Проверить товар в заказе");

        Assert.assertEquals(
                checkoutPage.getProductName(),
                "Sauce Labs Backpack",
                "На странице Overview должен отображаться Sauce Labs Backpack"
        );

        Allure.step("Проверить итоговую сумму");

        Assert.assertTrue(
                checkoutPage.getTotal().contains("Total:"),
                "На странице Overview должен отображаться итоговая сумма"
        );

        Allure.step("Завершить оформление заказа");

        checkoutPage.clickFinish();

        Allure.step("Проверить сообщение об успешном оформлении");

        Assert.assertEquals(
                checkoutPage.getCompleteMessage(),
                "Thank you for your order!",
                "После завершения заказа должно появиться сообщение об успешном оформлении"
        );
    }
}