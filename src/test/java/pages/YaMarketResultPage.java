package pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YaMarketResultPage {
    Logger logger = Logger.getLogger(getClass());

    private WebDriver driver;

    public YaMarketResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//article[1]//h3")
    private WebElement firstSearchResult;
    @FindBy(xpath = "//article[1]/div[3]/div[1]/div/a/div/span/span[1]")
    private WebElement price;
    @FindBy(xpath = "//input[contains(@value, \"grid\")]")
    private WebElement buttonView;

    public void switchView(){
        buttonView.click();
    }

    @Step("Получение цены первого найденного товара на странице 'результаты поиска' в Яндекс.Маркет")
    public int resultPageCost(){
        String textPrice = price.getText();
        if(textPrice.contains(" ")){
            textPrice = textPrice.replaceAll(" ", "");
        }
        int rpCost = Integer.parseInt(textPrice);
        return rpCost;
    }

    @Step("Переход на страницу 'карточка товара' в Яндекс.Маркет")
    public void productCard(){
        logger.info("Выполняется клик по ссылке");
        firstSearchResult.click();
    }


}
