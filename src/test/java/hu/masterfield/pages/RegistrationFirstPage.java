package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Regisztrciós űrlap első oldalának osztálya
 */
public class RegistrationFirstPage extends BasePage {

    // az oldalon található webelementek azonosítása, amelyekre szükségünk van.

    @FindBy(id = "title")
    private WebElement titleSelect;

    @FindBy(id="firstName")
    private WebElement fisrtName;

    @FindBy(id="lastName")
    private WebElement lastName;




    public RegistrationFirstPage(WebDriver driver) {
        super(driver);
    }
}
