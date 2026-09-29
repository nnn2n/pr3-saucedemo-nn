package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private final By productsTitle = By.cssSelector(".title");
    private final By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By cartLink = By.cssSelector(".shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getProductsTitle() {
        return getText(productsTitle);
    }

    public void addBackpackToCart() {
        click(backpackAddButton);
    }

    public String getCartCount() {
        return getText(cartBadge);
    }

    public void openCart() {
        click(cartLink);
    }
}