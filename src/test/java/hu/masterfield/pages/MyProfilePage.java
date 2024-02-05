package hu.masterfield.pages;

import hu.masterfield.datatypes.RegistrationData;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Feature("Profile oldal ellenőrzése és kitöltése módosult adatokkal")
public class MyProfilePage extends BasePage {

    protected static Logger logger = LogManager.getLogger(MyProfilePage.class);

    @FindBy(id = "title")
    private WebElement titleSelect;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "homePhone")
    private WebElement homePhone;

    @FindBy(id = "mobilePhone")
    private WebElement mobilePhone;

    @FindBy(id = "workPhone")
    private WebElement workPhone;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(id = "locality")
    private WebElement locality;

    @FindBy(id = "region")
    private WebElement region;

    @FindBy(id = "postalCode")
    private WebElement postalCode;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(xpath = "//button[@type='submit' and @class='btn btn-primary btn-sm']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@type='reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//div/strong[text()='Update Profile']")
    private WebElement profileUpdated;

    @Step("A Profil oldal elemei megjelenésének ellenőrzése")
    public boolean isLoaded() {
        boolean isLoaded = isLoaded(titleSelect)
                && isLoaded(firstName)
                && isLoaded(lastName)
                && isLoaded(homePhone)
                && isLoaded(mobilePhone)
                && isLoaded(workPhone)
                && isLoaded(address)
                && isLoaded(locality)
                && isLoaded(region)
                && isLoaded(postalCode)
                && isLoaded(country)
                && isLoaded(submitButton)
                && isLoaded(resetButton);
        logger.trace("isLoaded" + isLoaded);
        return isLoaded;
    }

    RegistrationData registrationData = new RegistrationData();

    @Step("Profil oldal kitöltése módosított adatokkal, majd mentés")
    public void writeMyProfilePage() {
        logger.trace("writeMyProfilePage() is called");
        Select selectTitle = new Select(titleSelect);
        selectTitle.selectByVisibleText(registrationData.getModTitle());
        firstName.clear();
        setTextbox(firstName, "modFirstNameInput", registrationData.getModFirstName());
        lastName.clear();
        setTextbox(lastName, "modLastNameInput", registrationData.getModLastName());
        homePhone.clear();
        setTextbox(homePhone, "modHomePhoneInput", registrationData.getModHomePhone());
        mobilePhone.clear();
        setTextbox(mobilePhone, "modMobilePhoneInput", registrationData.getModMobilePhone());
        address.clear();
        setTextbox(address, "modAddressInput", registrationData.getModAddress());
        locality.clear();
        setTextbox(locality, "modLocalityIput", registrationData.getModLocality());
        region.clear();
        setTextbox(region, "modRegion", registrationData.getModRegion());
        postalCode.clear();
        setTextbox(postalCode, "modPostalCodeInput", registrationData.getModPostalCode());
        country.clear();
        setTextbox(country, "modCountryInput", registrationData.getModCountry());

        takesScreenshot();

        submitButton.click();
        new MyProfilePage(driver);
    }

    @Step("Update Profile oldal betöltésének ellenőrzése")
    public boolean isLoadedUpdateProfile() {
        boolean isLoaded = isLoaded(profileUpdated)
                && isLoaded(titleSelect)
                && isLoaded(firstName)
                && isLoaded(lastName)
                && isLoaded(homePhone)
                && isLoaded(mobilePhone)
                && isLoaded(workPhone)
                && isLoaded(address)
                && isLoaded(locality)
                && isLoaded(region)
                && isLoaded(postalCode)
                && isLoaded(country)
                && isLoaded(submitButton)
                && isLoaded(resetButton);
        logger.trace("Update profile isloaded " + isLoaded);
        return isLoaded;
    }

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }
}
