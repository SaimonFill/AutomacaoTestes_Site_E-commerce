package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageElementMapper {

    @FindBy(className = "navigation_page")
    public WebElement navigation_page;

    @FindBy(className = "lighter")
    public WebElement lighter;

    @FindBy(className = "heading-counter")
    public WebElement heading_counter;

    @FindBy(linkText = "Faded Short Sleeve T-shirts")
    public WebElement linkProduct;

    @FindBy(linkText = "Send to a friend")
    public WebElement send_friend_button;

    @FindBy(id = "add_to_cart")
    public WebElement add_to_cart;

    @FindBy(linkText = "Proceed to checkout")
    public WebElement cartOk;

}
