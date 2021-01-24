package pages;


import org.openqa.selenium.WebDriver;
import utillits.Storage;
import utillits.RandomGenerator;


public class SignInPage extends BasePage{

    private String _sign_in_page_header  = "//form/h4[@class='dynamic-heading']";
    private String _email_id_field = "//input[@placeholder='Email Address' and @id='email']";
    private String _pwd_field = "//input[@placeholder='Password' and @id='password']";


    public SignInPage (WebDriver driver) {
        super(driver);
    }

    public SignInPage SignInPageHeaderValidation(String key){
        String signInPageHeader = getTheElementText("xpath", _sign_in_page_header);
        Storage.rememberTheValue(key, signInPageHeader);
        return this;
    }


    public SignInPage LoginWithRandomId(){

        String email = RandomGenerator.randomEmailGenerator();
        keyInValue("xpath", _email_id_field, email);
        keyInValue("xpAth", _pwd_field, email);
        return this;

    }




}

