package pages;

public class AllPage {
    public AllPage() {}
    private HomePage homePage;
    private LoginPage loginPage;
    private ResultPage resultPage;
    private WishListPage wishListPage;
    private Favorites favorites;

    public HomePage homePage(){
        if(homePage==null){
            homePage=new HomePage();
        }return homePage;
    }

    public LoginPage loginPage(){
        if(loginPage==null){
            loginPage=new LoginPage();
        }return loginPage;
    }

    public ResultPage resultPage(){
        if(resultPage==null){
            resultPage=new ResultPage();
        }return resultPage;
    }

    public WishListPage wishListPage(){
        if(wishListPage ==null){
            wishListPage =new WishListPage();
        }return wishListPage;
    }
    public Favorites favorites(){
        if(favorites ==null){
            favorites =new Favorites();
        }return favorites;
    }


}
