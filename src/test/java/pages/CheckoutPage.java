package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");

    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");

    private final By productName =
            By.cssSelector("[data-test='inventory-item-name']");

    private final By totalLabel = By.cssSelector("[data-test='total-label']");

    private final By completeHeader =
            By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillCustomerData(
            String firstName,
            String lastName,
            String postalCode) {

        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(postalCodeField, postalCode);
    }

    public void clickContinue() {
        click(continueButton);
    }

    public String getProductName() {
        return getText(productName);
    }

    public String getTotal() {
        return getText(totalLabel);
    }

    public void clickFinish() {
        click(finishButton);
    }

    public String getCompleteMessage() {
        return getText(completeHeader);
    }
}