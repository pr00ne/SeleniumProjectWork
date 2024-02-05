package hu.masterfield.pages;

import hu.masterfield.datatypes.RegistrationData;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static java.lang.System.getProperty;

/**
 * Regisztrciós űrlap első oldalának osztálya
 */

@Feature("Regisztráció - 1. oldal")
public class RegistrationFirstPage extends BasePage {

    public boolean isLoaded;
    // az oldalon található webelementek azonosítása, amelyekre szükségünk van.
    // Megszólítás
    @FindBy(id = "title")
    private WebElement titleSelect;
    // Keresztnév
    @FindBy(id = "firstName")
    private WebElement firstName;
    // Vezetéknév
    @FindBy(id = "lastName")
    private WebElement lastName;
    // Férfi választógomb
    @FindBy(xpath = "//input[@type='radio' and @name='gender' and @value='M']")
    private WebElement maleRadioButton;
    // Nő választógomb
    @FindBy(xpath = "//input[@value='F']")
    //  @FindBy(css="input[type='radio'][name='gender'][value='M']")
    private WebElement femaleRadioButton;
    // Születési dátum
    @FindBy(id = "dob")
    private WebElement dateOfBirth;
    //Társadalombiztosítási szám
    @FindBy(id = "ssn")
    private WebElement socialSecurityNumber;
    // E-mail cím
    @FindBy(id = "emailAddress")
    private WebElement emailAddress;
    //Jelszó
    @FindBy(id = "password")
    private WebElement password;
    //Jelszó megerősítés
    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;
    // Tovább gomb
    @FindBy(xpath = "//button[text()='Next']")
    private WebElement nextButton;
    // Bejelentkezés
    @FindBy(xpath = "//a[text()=' Sign in']")
    private WebElement signIn;

    public RegistrationFirstPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Ellenőrizzük, hogy megjelentek-e az oldalon az adott elemek.
     *
     * @return true, ha az oldal betöltődött, megjelentek az elvárt elemek és kattinthatóak
     */
    @Step("Regisztráció első oldalának betöltésének ellenőrzése")
    public boolean isLoaded() {
        boolean isLoaded = isLoaded(titleSelect)
                && isLoaded(firstName)
                && isLoaded(lastName)
                && isLoaded(maleRadioButton)
                && isLoaded(femaleRadioButton)
                && isLoaded(dateOfBirth)
                && isLoaded(socialSecurityNumber)
                && isLoaded(emailAddress)
                && isLoaded(password)
                && isLoaded(confirmPassword)
                && isLoaded(nextButton)
                && isLoaded(signIn);
        logger.trace("isLoaded= " + isLoaded);
        return isLoaded;
    }

    /**
     * Példányosítjuk a RegistrationData osztályt, hogy az oldalon található
     * input mezőket ki tudjuk tölteni a globalTestData.properties fileból felolvasott tesztadatokkal.
     */

    RegistrationData registrationData = new RegistrationData();

    /**
     * Regisztráció első oldalát valósítjuk meg.
     */

    @Step("Regisztrációs oldal 1. oldalának kitöltése")
    public RegistrationSecondPage registrationFirstPage() {
        logger.info("RegistrationFirstPage() called");

        logger.trace("titleSelect.select");

        Select selectTitle = new Select(titleSelect);
        selectTitle.selectByVisibleText(registrationData.getTitle());

        logger.trace("firstNameInputsendKeys");

        setTextbox(firstName, "firstnameInput", registrationData.getFirstname());
        setTextbox(lastName, "lastnameInput", registrationData.getLastname());

        if (registrationData.getGender().equals("M")) {
            if (maleRadioButton.isSelected()) {
                //To Do NOTHING
            } else {
                logger.trace("genderMaleRadio.click() called.");
                maleRadioButton.click();
            }
        }
        if (registrationData.getGender().equals("F")) {
            if (femaleRadioButton.isSelected()) {
                //To Do NOTHING
            } else {
                logger.trace("genderFemaleRadio.click() called.");
                femaleRadioButton.click();
            }
        }

        logger.trace("dateOfBirtInput.sendKeys(...) called");
        setTextbox(dateOfBirth, "dateOfBirthInput", registrationData.getDateOfBirt());
        setTextbox(socialSecurityNumber, "SocialsecurityNumber", registrationData.getSocialSecurityNumber());
        setTextbox(emailAddress, "emailAddress", registrationData.getEmailAddress());
        setTextbox(password, "password", registrationData.getPassword());
        setTextbox(confirmPassword, "confirmPassword", registrationData.getConfirmPassword());
        takesScreenshot();
        nextButton.click();
        return new RegistrationSecondPage(driver);
    }
}