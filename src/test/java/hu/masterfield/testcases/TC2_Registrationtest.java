package hu.masterfield.testcases;


import hu.masterfield.pages.GDPRBannerPage;
import hu.masterfield.pages.LoginPage;
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
        logger.info("Login page will be opened...");


        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isLoaded());
        loginPage.registrationStart();

    }


}
