package hu.masterfield.testcases;

import hu.masterfield.datatypes.RegistrationData;
import hu.masterfield.pages.*;
import hu.masterfield.utils.Screenshot;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * TC2 - Sikeres regisztráció érvényes adatok megadásával.
 */
public class TC2_Registrationtest extends BaseTest {

    private static Logger logger = LogManager.getLogger(TC2_Registrationtest.class);

    @Test
    @DisplayName("TC2_Registration")
    @Description("TC2 - Sikeres regisztráció teszteléseérvényes adatokkal")
    @Tag("TC2")
    @Tag("Regisztráció")

    public void TC2_Registrationtest(TestInfo testInfo) throws InterruptedException, IOException {
        logger.info(testInfo + "started.");
        Thread.sleep(1000);
        logger.info(testInfo + " started");

        GDPRBannerPage gdprPage = new GDPRBannerPage(driver);

        // a süti elfogadására szolgáló ablak megjelenésének ellenőrzése
        assertTrue(gdprPage.isCookieMessageVisible());

        // BasePage.takesScreenshot;
        Screenshot.takesScreenshot(driver);
        gdprPage.acceptCookies();
        Screenshot.takesScreenshot(driver);
        logger.info("Login page will be opened...");

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isLoaded());
        loginPage.registrationStart();

        RegistrationData registrationData = new RegistrationData();
        logger.info(registrationData);

        // Regisztrációs űrlap első oldalának kitöltése
        logger.info("RegistrationFirstPage betöltése");
        RegistrationFirstPage registrationFirstPage = new RegistrationFirstPage(driver);
        assertTrue(registrationFirstPage.isLoaded());

        RegistrationSecondPage registrationSecondPage = registrationFirstPage.registrationFirstPage();

        // Regisztrációs űrlap második oldalának kitöltése
        logger.info("RegistrationSecondPage betöltése");
        assertTrue(registrationSecondPage.isLoaded());
        LoginPage loginPageTwo = registrationSecondPage.registrationSecondPage();

        // Ellenőrzi, hogy a regisztráció sikeres volt-e, erről megjelent-e a szöveg
        logger.info("Regisztráció sikerességének ellenőrzése");
        assertTrue(loginPageTwo.registrationIsSuccessful());

        if (loginPageTwo.registrationIsSuccessful()) {
            logger.info("TEST PASSED");
            // TEST PASSED
        } else {
            fail("Registration failed");
        }
    }
}