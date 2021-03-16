package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPageElementMapper {

    @FindBy(css = "#id_gender1")
    public WebElement selectGender;

    @FindBy(css = "#customer_firstname")
    public WebElement firstName;

    @FindBy(css = "#customer_lastname")
    public WebElement lastName;

    @FindBy(css = "#passwd")
    public WebElement passWord;

    @FindBy(css = "#days > option:nth-child(16)")
    public WebElement dayOfBirth;

    @FindBy(css = "#months > option:nth-child(12)")
    public WebElement monthOfBirth;

    @FindBy(css = "#years > option:nth-child(26)")
    public WebElement yearOfBirth;

    @FindBy(css = "#firstname")
    public WebElement firstNameAdress;

    @FindBy(css = "#lastname")
    public WebElement lastNameAdress;

    @FindBy(css = "#company")
    public WebElement companyName;

    @FindBy(css = "#address1")
    public WebElement address;

    @FindBy(css = "#address2")
    public WebElement addressComplement;

    @FindBy(css = "#city")
    public WebElement city;

    @FindBy(css = "#id_state > option:nth-child(12)")
    public WebElement state;

    @FindBy(css = "#postcode")
    public WebElement postalCode;

    @FindBy(css = "#id_country > option:nth-child(2)")
    public WebElement country;

    @FindBy(css = "#phone_mobile")
    public WebElement mobilePhone;

    @FindBy(css = "#alias")
    public WebElement assignAddress;

    @FindBy(css = "#submitAccount > span")
    public WebElement clickRegister;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(1) > a")
    public WebElement myAccount;

}
