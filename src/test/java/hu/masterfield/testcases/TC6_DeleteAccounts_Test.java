package hu.masterfield.testcases;

import hu.masterfield.pages.GDPRBannerPage;
import hu.masterfield.pages.HomePage;
import hu.masterfield.pages.LoginPage;
import hu.masterfield.pages.ViewSavingsAccountsPage;
import hu.masterfield.utils.Consts;
import hu.masterfield.utils.GlobalTestData;
import jdk.jfr.Description;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.IOException;

public class TC6_DeleteAccounts_Test extends BaseTest{

    protected static Logger logger = LogManager.getLogger(TC6_DeleteAccounts_Test.class);

    @Test
    @DisplayName("TC6 - Számlák törlése")
    @Description("TC6 - Számlák törlése, majd ellenőrzés")
    @Tag("TC6")
    @Tag("Számlák törlése")
    public void TC6_DeleteAccount_Test(TestInfo testInfo) throws IOException {
        GlobalTestData globalTestData = new GlobalTestData();
        GDPRBannerPage gdprBannerPage = new GDPRBannerPage(driver);
        gdprBannerPage.acceptCookies();

        String emailAddress = globalTestData.getProperty(Consts.REG_EMAIL);
        String password = globalTestData.getProperty(Consts.REG_PASSWORD);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(emailAddress, password);

        HomePage homePage = new HomePage(driver);
        homePage.isLoaded();

        homePage.deleteData();

        homePage.gotoViewSavings();
        ViewSavingsAccountsPage viewSavingsAccountsPage = new ViewSavingsAccountsPage(driver);

        viewSavingsAccountsPage.noAccountsIsLoaded();
        takesScreenshot();
    }
}
