package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.util.Locale;

public class BaseTest {

    public WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\JARS\\chromedriver.exe");

        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();

        //Maximize Window
        driver.manage().window().maximize();

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }



}
