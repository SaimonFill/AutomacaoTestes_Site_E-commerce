package pageObjects;

import elementMapper.LoginPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Preenche campo do email para criar conta")
    public void enterEmailCreate(){
        enterEmailCreate.sendKeys("desafioweb@gmail.com");
    }

    public void clickBtnCreateAccount(){
        clickBtnCreateAccount.click();
    }

    public String getAuthenticationPageLogin(){
        return authenticationPageLogin.getText();
    }

    @Step("Valida se está na página de login")
    public boolean isPageLogin(){
        return getAuthenticationPageLogin().contains("AUTHENTICATION");
    }

}
