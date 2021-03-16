package pageObjects;

import elementMapper.CreateAccountPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class CreateAccountPage extends CreateAccountPageElementMapper {

    public CreateAccountPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Inicia procedimento de preencher campos")
    public void selectGender(){
        selectGender.click();
    }

    public void enterFirstName(){
        firstName.sendKeys("Saimon");
    }

    public void enterLastName(){
        lastName.sendKeys("Fill");
    }

    public void enterPassWord(){
        passWord.sendKeys("teste1234");
    }

    public void selectDayOfBirth(){
        dayOfBirth.click();
    }

    public void selectMonthOfBirth(){
        monthOfBirth.click();
    }

    public void selectYearOfBirth(){
        yearOfBirth.click();
    }

    public void enterFirstNameAdress(){
        firstNameAdress.sendKeys("Saimon");
    }

    public void enterLastNameAdress(){
        firstNameAdress.sendKeys("Fill");
    }

    public void enterCompanyName(){
        companyName.sendKeys("Empresa Teste");
    }

    public void enterAddress(){
        address.sendKeys("rua teste, 333");
    }

    public void enterAddressComplement(){
        addressComplement.sendKeys("apto 503 bl 12");
    }

    public void enterCity(){
        city.sendKeys("Novo Hamburgo");
    }

    public void selectState(){
        state.click();
    }

    public void enterPostalCode(){
        postalCode.sendKeys("00000");
    }

    public void selectCountry(){
        country.click();
    }

    public void enterMobilePhone(){
        mobilePhone.sendKeys("1111111");
    }

    public void enterAssignAddress(){
        assignAddress.sendKeys("Endereço Teste");
    }

    @Step("Clica em Register")
    public void clickRegister(){
        clickRegister.click();
    }

    public String getMyAccount(){
        return myAccount.getText();
    }

    @Step("Valida se criou a conta corretamente")
    public boolean isMyAccount(){
            return getMyAccount().contains("Saimon Fill");
    }

}
