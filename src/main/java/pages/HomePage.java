package pages;

import org.openqa.selenium.WebDriver;
import utillits.Storage;


public class HomePage extends BasePage{

    public HomePage (WebDriver driver){ super(driver); }

    final String _page_homepage_title = "//div[@id='zen_cs_desc_with_promo_dynamic']//h1";
    final String _page_homepage_signin_link = "//a[text()='Sign In']";



    String baseurl = "https://courses.letskodeit.com/";

    public HomePage gotoPage(){
        driver.get(baseurl);
        return this;
    }

    public SignInPage clickOnHomePageSignInLink(){
        clickTheElement("xpath", _page_homepage_signin_link);
        return new SignInPage(driver);
    }

    public HomePage validateHomePageTitle(String key){
        String headerTitle = getTheElementText("xpath", _page_homepage_title);
        Storage.rememberTheValue(key, headerTitle);
        return this;
    }






    // public HomePage MyAccountLink(){
    //    String MyAccountText=driver.findElement(myaccount).getText();
    //    Assert.assertEquals(MyAccountText,"Sign in");
    //   Utils.rememberTheValue("name1", "TCS");
    //    Utils.rememberTheValue("name2", "CTS");
    //   Utils.rememberTheValue("name3", "PWC");
    //return this;
    //}

    //public SignInPage SignInLink(){
    //   driver.findElement(myaccount).click();
    //    return new SignInPage(driver);
    //}


}
