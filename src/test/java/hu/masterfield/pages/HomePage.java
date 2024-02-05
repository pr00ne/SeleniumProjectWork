package hu.masterfield.pages;

import hu.masterfield.utils.Consts;
import hu.masterfield.utils.GlobalTestData;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Az oldalon található elemek azonosítása.")
public class HomePage extends BasePage {

    protected static Logger logger = LogManager.getLogger(HomePage.class);
    protected static GlobalTestData globalTestData = new GlobalTestData();

    //Home
    @FindBy(id="home-menu-item")
    private WebElement homeMenu;
    //Checking menu
    @FindBy(id = "checking-menu")
    private WebElement checkingMenu;
    // Checking menu -> View Checking
    @FindBy(id = "view-checking-menu-item")
    private WebElement viewCheckingMenuItem;
    // Cheking menu -> New Checking
    @FindBy(id = "new-checking-menu-item")
    private WebElement newCheckingMenuItem;
    // Savings menu
    @FindBy(id = "savings-menu")
    private WebElement savingsMenu;
    // Savings menu -> View Savings
    @FindBy(id = "view-savings-menu-item")
    private WebElement viewSavingsMenuItem;
    // Savings menu -> New Savging
    @FindBy(id = "new-savings-menu-item")
    private WebElement newSavingsMenuItem;
    // Welcome message
    @FindBy(xpath = "//div[@class='page-title']//li")
    // @FindBy(css = "div.page-title li")
    private WebElement labelTitle;
    // User avatar /picture
    @FindBy(css = "img.user-avatar.rounded-circle")
    private WebElement avatarDropdownMenuButton;
    // Avtar lenyitása -> My Profile
    @FindBy(xpath = "//a[contains(text(),'My Profile')]")
    // @FindBy(css="a.nav-link[href=\"/bank/user/profile\"]")
    private WebElement avatarDropdownMyProfileLink;
    // Avtar lenyitása -> Change Password
    @FindBy(xpath = "//a[contains(text(),'Change Password')]")
    // @FindBy(css="a.nav-link[href=\"/bank/user/password\"]")
    private WebElement avatarDropdownChangePasswordLink;
    // Avtar lenyitása -> Create Data
    @FindBy(xpath = "//a[contains(text(),'Create Data')]")
    // @FindBy(css="a.nav-link[href=\"/bank/user/create-data\"]")
    private WebElement avatarDropdownCreateDataLink;
    // Avtar lenyitása -> Delete Data
    @FindBy(xpath = "//a[contains(text(),'Delete Data')]")
    // @FindBy(css="a.nav-link[href=\"/bank/user/delete-data\"]")
    private WebElement avatarDropdownDeleteDataLink;
    // Avtar lenyitása -> Logout
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    // @FindBy(css="a.nav-link[href=\"/bank/logout\"]")
    private WebElement avatarDropdownLogoutLink;
    // Trasactions / transfers -> Withdraw
    @FindBy(id = "withdraw-menu-item")
    private WebElement withdrawLink;
    // Deposit
    @FindBy(id = "deposit-menu-item")
    private WebElement depositLink;

    /**
     * A homepageről elnavigál a Create Savings oldalra a menüben.
     *
     * @return a megnyitott Create Savings oldal objektuma
     */
    @Step("Navigálás a Create Savngs oldalra.")
    public CreateSavingsPage gotoNewSavings() {

        logger.info("gotoNewSavings() called");

        logger.trace("savingsMenu.click()");
        savingsMenu.click();

        logger.trace("newSavingsMenuItem.click()");
        newSavingsMenuItem.click();

        takesScreenshot();

        return new CreateSavingsPage(driver);
    }

    /**
     * HomePageről elnavigál a View Savings oldalra.
     *
     * @return a megynitott View Savings oldal objektuma
     */
    @Step("Navigálás a View Savings oldalra.")
    public ViewSavingsAccountsPage gotoViewSavings() {

        logger.info("gotoViewSavings() called");

        logger.trace("savingsMenu.click()");
        savingsMenu.click();

        logger.trace("viewSavingsMenuItem.click()");
        viewSavingsMenuItem.click();

        takesScreenshot();

        return new ViewSavingsAccountsPage(driver);

    }

    /**
     * HomePageről elnavigálunk a Deposit oldalra.
     *
     * @return a megnyitott Deposit oldal obektuma
     */
    @Step("Navigálás a Deposit oldalra.")
    public DepositPage gotoDepositPage() {

        logger.info("gotoDepositPage() called");

        logger.trace("depositLink.click()");
        depositLink.click();

        return new DepositPage(driver);
    }

    public TransactionsPage gotoTransactionsPage() {

        logger.info("gotoTransactionsPage() called ");

        logger.trace("savingsMenu.click()");
        savingsMenu.click();

        logger.trace("viewSavingsMenuItem.click()");
        viewSavingsMenuItem.click();

        return new TransactionsPage(driver);
    }

    /**
     * HomePageről elnavigálunk a MyProfile oldalra
     *
     * @return MyProfile oldal objektuma
     */
    @Step("Navigálás a Profil adatokat megjelenítő és módosító oldalra.")
    public MyProfilePage gotoMyProfilePage() {

        logger.info("gotoMyProfilePage() called");

        logger.trace("avatarDropdownMenuButton.click()");
        avatarDropdownMenuButton.click();

        logger.trace("avatarDropdownMyProfileLink.click()");
        avatarDropdownMyProfileLink.click();

        return new MyProfilePage(driver);
    }

    /**
     * Adatok törlése
     */
    @Step("Adatok törlése.")
    public void deleteData() {
        logger.info("deleteData() called");

        logger.trace("avatarDropdownMenuButton.click()");
        avatarDropdownMenuButton.click();

        logger.trace("avatarDropdownDeleteDataLink.click()");
        avatarDropdownDeleteDataLink.click();
    }

    public boolean isLoaded() {
        logger.info("HomePage.isLoaded() called");
        boolean isLoaded = isLoaded(savingsMenu)
                && isLoaded(checkingMenu)
                && isLoaded(avatarDropdownMenuButton);
        logger.trace("isLoaded= " + isLoaded);
        return isLoaded;
    }

    /**
     * Logout megvalósítása
     * @return LoginPage típusú objektum
     */

    @Step("Logout megvalósítása.")
    public LoginPage logout(){
        logger.info("logout() called");

        logger.trace("avatarDropdownMenuButton.click()");
        avatarDropdownMenuButton.click();

        logger.trace("avatarDropdownLogoutLink.click()");
        avatarDropdownLogoutLink.click();

        return new LoginPage(driver);
    }

    /**
     * HomePage ellenőrzése.
     */
    @Step("HomePage ellenőrzése.")
    public void validateHomePage(){
        logger.info("validateHomePage called");
        assertEquals("Digital Bank", driver.getTitle());
        assertTrue(driver.getCurrentUrl().endsWith("/bank/home"));
        assertEquals("Welcome " + globalTestData.getProperty(Consts.REG_FIRST_NAME)
                , labelTitle.getText());
    }
    /**
     * HomePage ellenőrzése profil módosítása után.
     */
    @Step("HomePage ellenőrzése profil mósosítása után.")
    public void validateHomePageAfterModifyProfile() {
        logger.info("validateHomePageAfterModifyProfile called");
        homeMenu.click();
        assertEquals("Digital Bank", driver.getTitle());
        assertTrue(driver.getCurrentUrl().endsWith("/bank/home"));
        assertEquals("Welcome " + globalTestData.getProperty(Consts.MOD_FIRST_NAME)
                , labelTitle.getText());
    }
    public HomePage(WebDriver driver) {
        super(driver);
    }
}
