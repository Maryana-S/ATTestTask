package pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GStartPage {
    Logger logger = Logger.getLogger(getClass());

    private WebDriver driver;

    public GStartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name = \"q\"]")
    private WebElement searchBar;

    public void enter() {
        logger.info("Нажатие на клавишу Enter");
        searchBar.sendKeys(Keys.ENTER);
    }

    @Step("Выполнение поискового запроса")
    public void search(String text){
        logger.info("Ввод поискового запроса в строку поиска " + text);
        searchBar.sendKeys(text);
        enter();

    }


}
