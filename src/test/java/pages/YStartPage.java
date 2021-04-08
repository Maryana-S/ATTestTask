package pages;


import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class YStartPage {
    Logger logger = Logger.getLogger(getClass());

    private WebDriver driver;

    public YStartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(id="text")
    private WebElement searchBar;

    @FindBy(xpath = "//div[@class='search2__button']//button")
    private WebElement buttonSearch;

    @Step("Выполнение поискового запроса {text}")
    public void search(String text){
        searchBar.sendKeys(text);
        buttonSearch.click();
        logger.info("Выполнение поискового запроса: " + text);
    }


}
