package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utillits.Storage;


public class CaseOneTest extends BaseTest{

    @Test (priority = 0)
    public void HomePageValidation() {
        HomePage homePage = new HomePage(driver);

        homePage.gotoPage()
                .validateHomePageTitle("homePageHeader")
                .clickOnHomePageSignInLink()
                .SignInPageHeaderValidation("titlehomepage");

        Assert.assertEquals(Storage.whatIsTheValue("homePageHeader"),"Complete Test Automation Bundle");
        Assert.assertEquals(Storage.whatIsTheValue("titlehomepage"),"Login");
    }

    @Test(priority = 1)
    public void LoginWithWrongEmailPwd(){
        HomePage homePage = new HomePage(driver);

        homePage.gotoPage()
                .clickOnHomePageSignInLink()
                .LoginWithRandomId()
                .SignInPageHeaderValidation("title");
        Assert.assertEquals(Storage.whatIsTheValue("title"),"Login");
    }
}
