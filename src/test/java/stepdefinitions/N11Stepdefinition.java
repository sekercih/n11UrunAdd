package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AllPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.io.IOException;
import java.time.Duration;


import static org.junit.Assert.*;

public class N11Stepdefinition {
    AllPage allPage=new AllPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    Actions actions=new Actions(Driver.getDriver());


    @Given("Kullanici {string} sitesinin anasayfasina gider.")
    public void kullaniciSitesininAnasayfasinaGider(String url) {
        Driver.getDriver().get(url);

    }

    @Then("Ana sayfanin acildigi kontrol edilir.")
    public void anaSayfaninAcildigiKontrolEdilir()throws IOException {
        String actualTitle="n11 - Hayat Sana Gelir";
        String expectedTitle=Driver.getDriver().getTitle();
        assertEquals("n11 homepage could not be reached",actualTitle,expectedTitle);
        ReusableMethods.getScreenshot("n11 Homepage accessed");
        allPage.homePage().aydinlatmaMetniAccept.click();
        wait.until(ExpectedConditions.visibilityOf(allPage.homePage().dahaSonraButton));
        allPage.homePage().dahaSonraButton.click();
        wait.until(ExpectedConditions.visibilityOf(allPage.homePage().acceptCookies));
        allPage.homePage().acceptCookies.click();
    }

    @When("Siteye login olunur.")
    public void siteyeLoginOlunur() throws IOException {
    allPage.homePage().signinButton.click();
    allPage.loginPage().emailBox.sendKeys(ConfigurationReader.getProperty("email"));
    allPage.loginPage().passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
    ReusableMethods.getScreenshot("Email password information entered");
    JSUtils.clickElementByJS(allPage.loginPage().loginButton);
    }

    @Then("Login islemi kontrol edilir.")
    public void loginIslemiKontrolEdilir() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(allPage.homePage().myaccountButton));
    assertTrue("Could not login to the site",allPage.homePage().myaccountButton.isDisplayed());
    ReusableMethods.getScreenshot("Login to the site with username and password");
    }

    @And("{string} kelimesi aranir.")
    public void kelimesiAranir(String product) throws IOException {
    allPage.homePage().searchBox.click();
    allPage.homePage().searchBox.sendKeys(product+Keys.ENTER);
    Driver.wait(1);
    ReusableMethods.getScreenshot("Product search done");
    }

    @Then("{string} kelimesi aratildigi kontrol edilir.")
    public void kelimesiAratildigiKontrolEdilir(String product) throws IOException {
        String actualResultText=allPage.resultPage().resultTextWebElement.getText();
        assertTrue("search results do not contain the searched word",actualResultText.contains(product));
        Driver.wait(1);
        ReusableMethods.getScreenshot("Search results contain the searched word");
    }

    @And("Arama sonuclari sayfasindan {int}. sayfa acilir.")
    public void aramaSonuclariSayfasindanSayfaAcilir(int pageNumber) {
        allPage.resultPage().secondPageButton.click();
    }


    @Then("{int}. sayfanin acildigi kontrol edilir.")
    public void sayfaninAcildigiKontrolEdilir(int pageNumber) throws IOException {
        String currentUrl=Driver.getDriver().getCurrentUrl();
        assertTrue("Could not accessed to second page",currentUrl.contains("pg="+pageNumber));
        ReusableMethods.getScreenshot("Second page accessed");
    }

    @And("Sayfadaki {int}. urun favorilere eklenir.")
    public void sayfadakiUrunFavorilereEklenir(int num) throws IOException {
        JSUtils.scrollIntoVIewJS(allPage.resultPage().addFavouriteButtonList.get(num-1));
        allPage.resultPage().addFavouriteButtonList.get(num-1).click();
        ReusableMethods.getScreenshot("Product added to favorites");
    }
    @And("Favorilerim sayfasina gidilir.")
    public void favorilerimSayfasinaGidilir() {
        allPage.homePage().myFavoritiesButton.click();
    }
    @Then("Favorilerim sayfasi acildigi kontrol edilir.")
    public void favorilerimSayfasiAcildigiKontrolEdilir() throws IOException {
        String actualTitle=allPage.wishListPage().accTitle.getText();
        assertTrue(actualTitle.contains("Favorilerim"));
        ReusableMethods.getScreenshot("My favorites page has been reached");
    }

    @And("Eklenen urun favorilerden silinir ve silme islemi kontrol edilir.")
    public void eklenenUrunFavorilerdenSilinirVeSilmeIslemiKontrolEdilir() throws IOException {
        allPage.wishListPage().favorilerimButton.click();
        allPage.favorites().deleteFromFavoritesButton.click();
        allPage.favorites().confirmButton.click();
        assertTrue("Failed to delete favorite product",allPage.favorites().emptyWatchListLogoWebElement.isDisplayed());
        ReusableMethods.getScreenshot("Product deleted from my favorites");
    }

    @Then("Uye cikis islemi yapilir.")
    public void uyeCikisIslemiYapilir() throws IOException {
        actions
                .moveToElement(allPage.homePage().myaccountButton)
                .click(allPage.homePage().logoutButton).perform();
        ReusableMethods.getScreenshot("Logged out of site");
    }



}
