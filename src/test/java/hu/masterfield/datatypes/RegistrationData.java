package hu.masterfield.datatypes;

import hu.masterfield.utils.Consts;
import hu.masterfield.utils.GlobalTestData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Hozzáférés biztosítása a GlobalTestData.properties fájlhoz.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RegistrationData {

    protected static GlobalTestData globalTestData = new GlobalTestData();

    private String title;
    private String firstname;
    private String lastname;
    private String gender;
    private String dateOfBirt;
    private String socialSecurityNumber;
    private String emailAddress;
    private String password;
    private String confirmPassword;
    private String address;
    private String locality;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;

    private String modTitle;
    private String modFirstName;
    private String modLastName;
    private String modAddress;
    private String modLocality;
    private String modRegion;
    private String modPostalCode;
    private String modCountry;
    private String modHomePhone;
    private String modMobilePhone;
    private String modWorkPhone;

    /**
     * Paraméter nélküli konstruktor, amivel a globalTestdata.properties fileból
     * hozzáférünk a tesztadatokhoz.
     * A példányosításnál hozzáférünk a tesztadatokhoz.
     */
    public RegistrationData() {
        this.title = globalTestData.getProperty(Consts.REG_TITLE);
        this.firstname = globalTestData.getProperty(Consts.REG_FIRST_NAME);
        this.lastname = globalTestData.getProperty(Consts.REG_LAST_NAME);
        this.gender = globalTestData.getProperty(Consts.REG_GENDER);
        this.dateOfBirt = globalTestData.getProperty(Consts.REG_DATE_OF_BIRTH);
        this.socialSecurityNumber = globalTestData.getProperty(Consts.REG_SOCIAL_SECURITY_NUMBER);
        this.emailAddress = globalTestData.getProperty(Consts.REG_EMAIL);
        this.password = globalTestData.getProperty(Consts.REG_PASSWORD);
        this.confirmPassword = globalTestData.getProperty(Consts.REG_CONFIRM_PASSWORD);
        this.address = globalTestData.getProperty(Consts.REG_ADDRESS);
        this.locality = globalTestData.getProperty(Consts.REG_LOCALITY);
        this.region = globalTestData.getProperty(Consts.REG_REGION);
        this.postalCode = globalTestData.getProperty(Consts.REG_POSTAL_CODE);
        this.country = globalTestData.getProperty(Consts.REG_COUNTRY);
        this.homePhone = globalTestData.getProperty(Consts.REG_HOME_PHONE);
        this.mobilePhone = globalTestData.getProperty(Consts.REG_MOBILE_PHONE);
        this.workPhone = globalTestData.getProperty(Consts.REG_WORK_PHONE);

        this.modTitle = globalTestData.getProperty(Consts.MOD_TITLE);
        this.modFirstName = globalTestData.getProperty(Consts.MOD_FIRST_NAME);
        this.modLastName = globalTestData.getProperty(Consts.MOD_LAST_NAME);
        this.modAddress = globalTestData.getProperty(Consts.MOD_ADDRESS);
        this.modLocality = globalTestData.getProperty(Consts.MOD_LOCALITY);
        this.modRegion = globalTestData.getProperty(Consts.MOD_REGION);
        this.modPostalCode = globalTestData.getProperty(Consts.MOD_POSTAL_CODE);
        this.modCountry = globalTestData.getProperty(Consts.MOD_COUNTRY);
        this.modHomePhone = globalTestData.getProperty(Consts.MOD_HOME_PHONE);
        this.modWorkPhone = globalTestData.getProperty(Consts.MOD_WORK_PHONE);
        this.modMobilePhone = globalTestData.getProperty(Consts.MOD_MOBILE_PHONE);
    }
}