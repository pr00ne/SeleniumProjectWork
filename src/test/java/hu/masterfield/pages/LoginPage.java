package hu.masterfield.pages;

/* Bejelentkezési képernyő osztálya
 */

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Bejelentkezési képernyő kezelése")

public class LoginPage extends BasePage {

    protected static Logger logger = LogManager.getLogger(LoginPage.class);

    /* Az oldalon található webelementek azonosítása
    Ezel szükségesek a bejelentkezés megvalósításához és a regisztráció elindításához.
     */

    @FindBy(id = "username")
    private WebElement usernameInput; //bejelentkezési felhasználónév

    @FindBy(id = "password")
    private WebElement passwordInput; //bejelentkezési jelszó

    @FindBy(id = "submit")
    private WebElement submitButton; //bejelentkezés gomb

    // @FindBy(linkText = " Sign Up Here"

    @FindBy(xpath = "//a[text()=' Sign Up Here']")
    private WebElement registrationLink; // regisztrációs link

    @FindBy(xpath = "//span[text()='Registration Successful. Please Login.']")
    private WebElement registrationSuccessfulLabel; // sikeres regisztráció visszajelzés

    //  @FindBy(xpath = "//p[test()='Az oldal sütiket használ']")
    @FindBy(id = "cc-nb-title")
    private static WebElement cookieUsageMessage; // cookie elem

    @FindBy(xpath = "//div[span[text()='Success'] and contains(.,'Logout completed.')]")
    private WebElement logoutCompletedMessage; // sikeres kijelentkezésről tájékoztatás

    @FindBy(id = "remember-me")
    private WebElement rememberMeCheckbox; //emlékezz rám választó


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Ellenőrzi, hogy megjelentek-e az oldalon a megadott elemek.
     *
     * @return true az oldal betöltődött, megjelentek az elemek és kattinthatóak.
     */

    @Step("Login oldal betöltésének ellenőrzése")
    public boolean isLoaded() {
        boolean isLoaded = isLoaded(usernameInput)
                && isLoaded(passwordInput)
                && isLoaded(submitButton)
                && isLoaded(registrationLink)
                && isLoaded(rememberMeCheckbox);
        logger.trace("isLoaded = " + isLoaded);
        return isLoaded;
    }

    /**
     * Ellenőrzi, hogy a sikeres regisztráció után megjelent-e az oldalon a megadott elem.
     *
     * @return true az oldalon megjelent az elvárt szöveg
     */
    @Step("Regisztráció sikerességének ellenőrzése")
    public boolean registrationIsSuccessful() {
        logger.info("registrationIsSuccessful() called");
        boolean isRegistrationSuccessful = isLoaded(registrationSuccessfulLabel);
        logger.trace("registration is success = " + isRegistrationSuccessful);

        assertEquals("Digital Bank", driver.getTitle());
        assertTrue(driver.getCurrentUrl().endsWith("/bank/register"));
        assertTrue(registrationSuccessfulLabel.getText().contains("Success"));
        assertEquals("Registration Successful. Please Login.", registrationSuccessfulLabel.getText());

        return isRegistrationSuccessful;
    }

    /**
     * Bejelentkezést megvalósító függvény
     *
     * @param username Digital Bank felhasználó
     * @param password Digital Bank jelszó
     * @return a nyitó oldalt megvalósító HomePage objektum
     */
    @Step("Bejelentkezés")
    public HomePage login(String username, String password) {
        logger.info("login() called with username = " + username + ", password = " + password + ".");

        setTextbox(usernameInput, "usernameInput", username);
        setTextbox(passwordInput, "passwordInput", password);

        takesScreenshot();

        logger.trace("submitButton.click()");
        submitButton.click();

        takesScreenshot();

        return new HomePage(driver);
    }

    /**
     * Regisztráció indítása
     */
    @Step("Regisztráció")
    public void registrationStart() {
        logger.trace("registrationLink.click()");
        registrationLink.click();
    }

    /**
     * Logout ellenőrzése
     *
     * @return true , abban az esetben, ha sikeres volt a kilépés
     */
    @Step("Logout ellenőrzése")
    public boolean validateLogout() {
        boolean isLogoutSuccess = isLoaded(usernameInput)
                && isLoaded(passwordInput)
                && isLoaded(submitButton)
                && isLoaded(registrationLink)
                && isLoaded(rememberMeCheckbox)
                && isLoaded(logoutCompletedMessage);

        logger.info("isLogoutSuccess= " + isLogoutSuccess);

        return isLogoutSuccess;

    }

    /**
     * Cookiek ellenőrzése
     *
     * @return true, ha a "sütiket használ az oldal" szöveget tartalmazó webelement látható az oldalon
     */

    @Step("Cookiek ellenőrzése")
    public static boolean isCookieVisible() {
        boolean isCookieVisible = cookieUsageMessage.isDisplayed();
        logger.info("isCookieVisible= " + isCookieVisible);
        return isCookieVisible;
    }
}

