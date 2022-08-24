package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage extends BasePage{

    @FindBy(css = "div.resultText")
    public WebElement resultTextWebElement;



    @FindBy(linkText = "2")
    public WebElement secondPageButton;

    @FindBy(className = "followBtn")
    public List<WebElement> addFavouriteButtonList;
}
