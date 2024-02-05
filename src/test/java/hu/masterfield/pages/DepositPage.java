package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends BasePage {

    @FindBy(id = "page-title")
    private WebElement pageTitle;

    @FindBy(id = "selectedAccount")
    private WebElement selectedAccount;

    @FindBy(id = "amount")
    private WebElement deposirtAmount;

    @FindBy(xpath = "//button[@type='submit' and @class='btn btn-primary btn-sm']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@type='reset']")
    private WebElement resetButton;

    public DepositPage(WebDriver driver) {
        super(driver);
    }
}
