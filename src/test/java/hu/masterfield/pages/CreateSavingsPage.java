package hu.masterfield.pages;

import hu.masterfield.datatypes.Saving;
import hu.masterfield.utils.Consts;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.apache.logging.log4j.LogManager;


/**
 * Megtakarítás típusú accountok létrehozásáért felelős osztály
 */

@Feature("Megtakarítás típusú accountok létrehozásáért felelős osztály")
public class CreateSavingsPage extends BasePage {

    protected static Logger logger = LogManager.getLogger(CreateSavingsPage.class);

    // Az oldalon található webelementek azonosítása.
    // Ezek szükségesek a Savings accountok létrehozásához-

    // Savings radio button
    @FindBy(id = Consts.ACCOUNT_TYPES_SAVINGS)
    private WebElement radioSavings;
    // Money Market radio button
    @FindBy(id = Consts.ACCOUNT_TYPES_MONEY_MARKET)
    private WebElement radioMoneyMarket;
    //Individual radio button
    @FindBy(id = Consts.OWNERSHIP_TYPES_INDIVIDUAL)
    private WebElement radioIndividual;
    @FindBy(id = Consts.OWNERSHIP_TYPES_JOINT)
    private WebElement radioJoint;
    //account name
    @FindBy(id = "name")
    private WebElement textName;
    //openingbalance
    @FindBy(id = "openingBalance")
    private WebElement testOpeningBalance;
    //new Savings submit
    @FindBy(id = "newSavingsSubmit")
    private WebElement buttonNewSavingsSubmit;

    public CreateSavingsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Új Saving létrehozása
     *
     * @return ViewSavingsAccountsPage, ha sikerült létrehozni a Savings típusú objektumot
     */
    @Step("Új Saving létrehozása")
    public ViewSavingsAccountsPage createNewSaving(Saving saving) {
        logger.info("createNewSaving() called");
        if (saving.getAccountTypes().equals(Consts.ACCOUNT_TYPES_SAVINGS)) {
            //radio button esetében ez az ellenőrzés nem szükséges
            if (radioSavings.isSelected()) {
                //TO DO NOTHING
            } else
                radioSavings.click();
        }
        if (saving.getAccountTypes().equals(Consts.ACCOUNT_TYPES_MONEY_MARKET)) {
            if (radioMoneyMarket.isSelected()) {
                //TO DO NOTHING
            } else
                radioMoneyMarket.click();
        }
        if (saving.getOwnershipTypes().equals(Consts.OWNERSHIP_TYPES_INDIVIDUAL)) {
            radioIndividual.click();
        }
        if (saving.getOwnershipTypes().equals((Consts.OWNERSHIP_TYPES_JOINT))) {
            radioJoint.click();
        }
        //  textName.sendKeys(saving.getAccountName());
        setTextbox(textName, "Account Name", saving.getAccountName());
        setTextbox(testOpeningBalance, "Opening Balance", saving.getOpeningBalance());
        takesScreenshot();
        buttonNewSavingsSubmit.click();
        return new ViewSavingsAccountsPage(driver);
    }
}