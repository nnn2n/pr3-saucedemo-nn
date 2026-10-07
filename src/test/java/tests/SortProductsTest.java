package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

@Epic("SauceDemo UI Testing")
@Feature("Каталог товаров")
public class SortProductsTest extends BaseTest {

    @Test
    @Story("Сортировка товаров по названию")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Anastasia")
    public void sortProductsZATest() {

        Allure.step("Авторизоваться стандартным пользователем");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Открыть каталог товаров");

        InventoryPage inventoryPage = new InventoryPage(driver);

        Allure.step("Выбрать сортировку товаров от Я до А");

        inventoryPage.sortProductsZA();

        Allure.step("Проверить первый товар после сортировки");

        Assert.assertEquals(
                inventoryPage.getFirstProductName(),
                "Test.allTheThings() T-Shirt (Red)",
                "После сортировки Z-A первым должен отображаться Test.allTheThings() T-Shirt (Red)"
        );
    }
}