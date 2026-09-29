package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By backpackName = By.cssSelector(".inventory_item_name");
    private final By backpackPrice = By.cssSelector(".inventory_item_price");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getText(backpackName);
    }

    public String getProductPrice() {
        return getText(backpackPrice);
    }

    public void clickCheckout() {
        click(checkoutButton);
    }
}