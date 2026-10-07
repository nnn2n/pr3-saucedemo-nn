package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

@Epic("SauceDemo UI Testing")
@Feature("Авторизация")
public class LoginTest extends BaseTest {

    @Test
    @Story("Успешная авторизация")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Anastasia")
    public void positiveLoginTest() {

        Allure.step("Выполнить вход стандартным пользователем");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Allure.step("Проверить успешный переход на страницу товаров");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "После успешной авторизации должна открыться страница товаров"
        );
    }

    @Test
    @Story("Авторизация заблокированного пользователя")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Anastasia")
    public void lockedOutUserLoginTest() {

        Allure.step("Выполнить вход заблокированным пользователем");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        Allure.step("Проверить сообщение об ошибке");

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("locked out"),
                "Для заблокированного пользователя должно отображаться сообщение об ошибке"
        );
    }
}