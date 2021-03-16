package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Browser;

//Classe para fazer o mouseOver

public class BasePage extends Browser {

    public static void mouseOver(WebElement element){
        Actions action = new Actions(Browser.getCurrentDriver());
        action.moveToElement(element).build().perform();
    }
}
