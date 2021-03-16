package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElementMapper {

    @FindBy(css = "#email_create")
    public WebElement enterEmailCreate;

    @FindBy(css = "#SubmitCreate > span")
    public WebElement clickBtnCreateAccount;

    @FindBy(className = "page-heading")
    public WebElement authenticationPageLogin;
}
