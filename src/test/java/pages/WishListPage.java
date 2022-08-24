package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{

    @FindBy(css = "h2.accTitle")
    public WebElement accTitle;

    @FindBy(css = "h4.listItemTitle")
    public WebElement favorilerimButton;
}
