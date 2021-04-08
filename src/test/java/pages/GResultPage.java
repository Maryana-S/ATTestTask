package pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GResultPage {
    Logger logger = Logger.getLogger(getClass());

    private WebDriver driver;

    public GResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@class = \"jpu5Q VqFMTc p8AiDd\"]/../../div[contains(@role, \"heading\")]")
    private WebElement ad;

    @FindBy(xpath = "//span[@class = \"jpu5Q VqFMTc p8AiDd\"]/../../div[contains(@role, \"heading\")]/..//span[@class=\"Zu0yb LWAWHf qzEoUe\"]")
    private WebElement gTitleSite;

    @FindBy(xpath = "//div[@class = \"yuRUbf\"]//h3//span")
    private WebElement wad;

    @FindBy(xpath = "//div[@id = \"result-stats\"]")
    private WebElement count;


    @Step("Выявление количества найденных результатов")
    public String quantity(){
        logger.info("Текст надписи веб элемента 'количество найденных результатов'");
        return count.getText();
    }


    public String wadName() {
        logger.info("Текст надписи первого результата поиска");
        return wad.getText();
    }

    public String countName() {
        logger.info("Текст надписи веб элемента 'количество найденных результатов'");
        return count.getText();
    }

    @Step("Количество результатов поиска")
    public int gCount(){
        int gResultQ;
        String gSR = quantity();
        int intBracket = gSR.indexOf("(");
        String gResult = gSR.substring(22, intBracket - 1);
        String gRes = gResult.replaceAll(" ","");
        gResultQ = Integer.parseInt(gRes);
        logger.info("Количество найденных результатов в чистовом выражении");
        return gResultQ;
    }

    public String gTitleAd() {
        logger.info("Текст заголовка первого рекламного результата");
        return ad.getText();
    }

    @Step("Получение адреса первого найденного рекламного объявления")
    public String gGetSiteTitle(){
        logger.info("Наименование адреса первого рекламного сайта в Google'");
        String mid = gTitleSite.getText();
        return mid.substring(4, mid.length() - 1);
    }

}
