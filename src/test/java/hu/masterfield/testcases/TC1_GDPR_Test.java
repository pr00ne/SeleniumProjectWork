package hu.masterfield.testcases;

import hu.masterfield.pages.BasePage;
import hu.masterfield.pages.GDPRBannerPage;
import hu.masterfield.utils.Screenshot;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * TC1 - GDPR nyilakozat sikeres elfogadása
 */
public class TC1_GDPR_Test extends BaseTest {
    protected static Logger logger = LogManager.getLogger(TC1_GDPR_Test.class);

    @Test
    @DisplayName("TC1_GDPR_test")
    @Description("TC1 - GDPR nyilatkozat sikeres elfogadása")
    @Tag("TC1")
    @Tag("GDPR")
    public void test_TC1_GDPR(TestInfo testInfo) throws IOException, InterruptedException {
        Thread.sleep(1000);
        logger.info(testInfo + " started");

        GDPRBannerPage gdprPage = new GDPRBannerPage(driver);
        // a süti elfogadására szolgáló ablak megjelenésének ellenőrzése

        assertTrue(gdprPage.isCookieMessageVisible());
        // BasePage.takesScreenshot;
        Screenshot.takesScreenshot(driver);
        gdprPage.acceptCookies();
        logger.info("Login page will be opened...");
        logger.info("Login");
        Screenshot.takesScreenshot(driver);
        Thread.sleep(1000);


    }


}
