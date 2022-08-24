package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Favorites extends BasePage{

    @FindBy(css = "span.deleteProFromFavorites")
    public WebElement deleteFromFavoritesButton;

    @FindBy(css = "span.confirm")
    public WebElement confirmButton;

    @FindBy(css = "div.emptyWatchList")
    public WebElement emptyWatchListLogoWebElement;

}
