package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage{


    @FindBy(css = "span.btn")
    public WebElement aydinlatmaMetniAccept;

    @FindBy(css= "button.dn-slide-deny-btn")
    public WebElement dahaSonraButton;

    @FindBy(css= "a[title=\"Giriş Yap\"]")
    public WebElement signinButton;

    @FindBy(xpath = "//span[.=\"Tümünü Kabul Et\"]")
    public WebElement acceptCookies;

    @FindBy(css = "div.myAccount.myAccountElliptical")
    public WebElement myaccountButton;

    @FindBy(id = "searchData")
    public WebElement searchBox;

    @FindBy(css = "div.btnMyFavorites")
    public WebElement myFavoritiesButton;

    @FindBy(css = "a.logoutBtn")
    public WebElement logoutButton;
}
