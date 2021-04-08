package pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YaMarketStartPage {

    Logger logger = Logger.getLogger(getClass());

    private WebDriver driver;

    public YaMarketStartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[contains(@id, \"header-search\")]")
    private WebElement searchBar;
    @FindBy(xpath = "//button[contains(@type, \"submit\")]")
    private WebElement searchButton;

    @Step("Выполнение поискового запроса {request} в Яндекс.Маркет")
    public void search(String request){
        searchBar.sendKeys(request);
        searchButton.click();
        logger.info("Вызван метод 'search' c параметром " + request + ", осуществляется переход на страницу 'карточка товара'");
    }


}
