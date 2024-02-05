package hu.masterfield.testcases;

import hu.masterfield.pages.GDPRBannerPage;
import hu.masterfield.pages.HomePage;
import hu.masterfield.pages.LoginPage;
import hu.masterfield.pages.MyProfilePage;
import hu.masterfield.utils.Consts;
import hu.masterfield.utils.GlobalTestData;
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
 * TC5 - Profil adatok megváltoztatása
 */
public class TheChangeProfileData extends BaseTest {

    protected static Logger logger = LogManager.getLogger(TheChangeProfileData.class);
    protected static GlobalTestData globalTestData = new GlobalTestData();

    @Test
    @DisplayName("ChangeDataUser")
    @Description("User profil adatainak megváltoztatása")
    @Tag("TC5")

    public void changeUserData(TestInfo testInfo) throws IOException {
        logger.trace(testInfo.getDisplayName() + "started");

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
        homePage.validateHomePage();

        //Navigálás a Profil oldalra
        homePage.gotoMyProfilePage();

        MyProfilePage myProfilePage = new MyProfilePage(driver);
        assertTrue(myProfilePage.isLoaded());
        logger.trace("My Profile Page is Loaded" + myProfilePage.isLoaded());

        //Profil adatok kitöltése a módosított adatokkal

        logger.trace("writeMyProfilePage() is called.");
        myProfilePage.writeMyProfilePage();

        //Profil adatok mentésének ellenőrzése
        logger.trace("My Profile Page Updates is Loaded " + myProfilePage.isLoadedUpdateProfile());
        assertTrue(myProfilePage.isLoadedUpdateProfile());

        //HomePage ellenőrzése módosítás után
        homePage.validateHomePageAfterModifyProfile();

        takesScreenshot();
    }
}
