package pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YaMarketProdactCardPage {

    Logger logger = Logger.getLogger(getClass());

    private WebDriver driver;

    public YaMarketProdactCardPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//article[1]//div[@data-zone-name=\"price\"]//span/span[1]")
    private WebElement price;

    @Step("Получение цены товара на странице 'карточка продукта' в Яндекс.Маркет")
    public int prodactCardCost(){
        String textPCCost = price.getText();
        if(textPCCost.contains(" ")){
            textPCCost = textPCCost.replaceAll(" ", "");
        }
        int pcCost = Integer.parseInt(textPCCost);
        return pcCost;
    }

}
