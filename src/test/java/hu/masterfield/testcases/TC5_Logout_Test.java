package hu.masterfield.testcases;

import hu.masterfield.apitestcases.BaseAPITest;
import hu.masterfield.pages.GDPRBannerPage;
import hu.masterfield.pages.HomePage;
import hu.masterfield.pages.LoginPage;
import hu.masterfield.utils.Consts;
import hu.masterfield.utils.GlobalTestData;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC5_Logout_Test extends BaseTest {
    @Test
    @DisplayName("TC5 - Logout")
    @Description("TC5 - Sikeres bejelentkezés után kijelentkezés a rendszerből")
    @Tag("TC5")
    @Tag("Kijelentkezés")
    public void TC5_LogoutTest(TestInfo testInfo) throws InterruptedException, IOException {
        GlobalTestData globalTestData = new GlobalTestData();
        logger.info(testInfo + " started.");

        // Cookie-k elfogadása
        GDPRBannerPage gdprPage = new GDPRBannerPage(driver);
        gdprPage.acceptCookies();

        logger.info("Login page betöltése");
        // Belépés az oldalra
        String emailAddress = globalTestData.getProperty(Consts.REG_EMAIL);
        String password = globalTestData.getProperty(Consts.REG_PASSWORD);

        logger.info("Login");
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isLoaded());

        HomePage homePage = loginPage.login(emailAddress, password);
        assertTrue(homePage.isLoaded());
        homePage.isLoaded();

        homePage.logout();
        assertTrue(loginPage.isLoaded());

        takesScreenshot();
    }
}
