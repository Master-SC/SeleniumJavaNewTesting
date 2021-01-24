package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage (WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver,15);
    }

    // Not Using Currently
    private By getByType(String locatorType, String locator){
        locatorType = locatorType.toLowerCase();

        switch (locatorType) {
            case "xpath":
                return By.xpath(locator);

            case "id":
                return By.id(locator);

            case "class":
                return By.className(locator);

            case "link":
                return By.linkText(locator);

            default:
                System.out.println("The Locator Type: '" + locatorType + "' is not is not supported");

        }
        return null;
    }

    // Not using Currently
    public WebElement getElement(String locatorType, String locator){
        WebElement element = null;
        try {
            locatorType = locatorType.toLowerCase();
            By byType = getByType(locatorType, locator);
            element = driver.findElement(byType);
            System.out.println("Element with Locator Type: '"+locatorType+"' with locator: '"+locator+"' is present");
        } catch (Exception e){
            e.getStackTrace();
            System.out.println("Element with Locator Type: '"+locatorType+"' with locator '"+locator+"'" +
                    " is not present");
        }
        return element;
    }

    private String validateWebElementType(String locatorType){
        String locatorTypeF = null;
        locatorType = locatorType.toLowerCase();

            switch (locatorType) {
                case "id":
                    locatorTypeF = "id";
                    System.out.println("Locator Type is: '" + locatorType +"'");
                    break;
                case "xpath":
                    locatorTypeF = "xpath";
                    System.out.println("Locator Type is: '" + locatorType +"'");
                    break;
                case "link":
                    locatorTypeF = "link";
                    System.out.println("Locator Type is: '" + locatorType +"'");
                    break;
            } return locatorTypeF;
    }


    public WebElement getElementMod(String locatorType, String locator){
        WebElement getTheElement = null;
        locatorType = validateWebElementType(locatorType);

        if (locatorType != null){
                switch (locatorType) {
                    case "id":
                        getTheElement= driver.findElement(By.id(locator));
                        System.out.println("Element with Locator Type: '"+locatorType+"' with locator '"+locator+"'" +
                                " is not present");
                        break;
                    case "xpath":
                        getTheElement= driver.findElement(By.xpath(locator));
                        System.out.println("Element with Locator Type: '"+locatorType+"' with locator '"+locator+"'" +
                                " is not present");
                        break;
                    case "link":
                        getTheElement= driver.findElement(By.linkText(locator));
                        System.out.println("Element with Locator Type: '"+locatorType+"' with locator '"+locator+"'" +
                                " is not present");
                        break;
                }
        }
        else {
            System.out.println("Element not Found with locator");
        }
        return getTheElement;
    }



    public void clickTheElement(String locatorType, String locator){

        try{
            getElementMod(locatorType, locator).click();
            System.out.println("Element is clickable with Locator Type: '"+locatorType+"' & locator: '"
                    +locator+"'");
        } catch (Exception e){
            e.getStackTrace();
            System.out.println("Element is not clickable with Locator Type: '"+locatorType+"' & locator: '"
                    +locator+"'");
        }

    }

    public void keyInValue(String locatorType, String locator, String value){
        try{
            getElementMod(locatorType, locator).sendKeys(value);
            System.out.println("Field is editable with Locator Type: '"+locatorType+"' & locator: '"
                    +locator+"'");
        } catch (Exception e){
            e.getStackTrace();
            System.out.println("Field is not editable with Locator Type: '"+locatorType+"' & locator: '"
                    +locator+"'");
        }
    }

    public String getTheElementText(String locatorType, String locator){
        String str = null;
        try{
            str = getElementMod(locatorType, locator).getText();
            System.out.println("Text Value is present with Locator Type: '"+locatorType+"' & locator: '"
                    +locator+"'");
        } catch (Exception e){
            e.getStackTrace();
            System.out.println("Text Value is not present with Locator Type: '"+locatorType+"' & locator: '"
                    +locator+"'");
            return null;
        }
        return str;
    }








}
