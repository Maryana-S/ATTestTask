package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

public class YResultPage {
    Logger logger = Logger.getLogger(getClass());
    private WebDriver driver;


    public YResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[contains(@class, \"label_theme_direct\")]/../../h2")
    private WebElement ad;

    @FindBy(xpath = "//li[1]//div[contains(@class, \"label_theme_direct\")]/../../h2/../div[contains(@class, \"organic__subtitle\")]//b")
    private WebElement yaTitleSite;

    @FindBy(xpath = "//div[contains(@class,\"label label_theme_direct\")]")
    private WebElement labelAd;

    @FindBy(xpath = "(//*[@id='search-result']/li)[1]//div[contains(@class, \"organic__subtitle\")]")
    private WebElement subtitle;


    @Step("Получение текста, содержащегося в лейбле {labelAd}")
    public String getLabelAd(){
        logger.info("Текст надписи лейбла 'реклама'");
        return labelAd.getText();
    }

    @Step("Получение текста, содержащегося в 'subtitle'")
    public String getSubtitle(){
        logger.info("Текст надписи веб элемента 'subtitle'");
        return subtitle.getText();
    }

    @FindBy(xpath = "//*[@id='search-result']/li[1]//h2/../../*[not (.//*[contains(@class, 'label_theme_direct')])]/h2")
    private WebElement wad;


    @FindBy(xpath = "//*[@id=\"search-result-aside\"]/div[@class = \"serp-list serp-list_right_yes\"]/div[@class = \"serp-adv__found\"]")
    private WebElement count;


    @Step("Выявление количества найденных результатов")
    public String quantity(){
        logger.info("Текст надписи веб элемента 'количество найденных результатов'");
        return count.getText();
    }


    public String wadName() {
        logger.info("Текст надписи первого найденного результата без рекламы'");
        return wad.getText();
    }

    public String countName() {
        logger.info("Текст надписи веб элемента 'количество найденных результатов'");
        return count.getText();
    }
    @Step("Количество результатов поиска")
    public int yaCount(){
        int yaResultQ;
        String yaSR = quantity();
        if(yaSR.contains("млн")){
            int intMln = yaSR.indexOf("м");
            String yanumber = yaSR.substring(8,intMln - 1);
            yaResultQ = Integer.parseInt(yanumber) * 1000000;
        }
        else if(yaSR.contains("тыс")){
            int intTys = yaSR.indexOf("т");
            String yanumber = yaSR.substring(8, intTys - 1);
            yaResultQ = Integer.parseInt(yanumber) * 1000;
        }

        else{
            int intRes = yaSR.indexOf("р");
            String yanumber = yaSR.substring(8, intRes - 1);
            yaResultQ = Integer.parseInt(yanumber);
        }
        logger.info("Количество найденных результатов в числовом значении: " + yaResultQ);
        return yaResultQ;
    }

    public String yaTitleAd(){
        logger.info("Наименование первого результата поиска с рекламой");
        return ad.getText();

    }

    @Step("Получение адреса первого найденного рекламного объявления")
    public String yaGetSiteTitle(){
        logger.info("Наименование адреса первого рекламного объявления в Yandex");
        return yaTitleSite.getText();
    }
}



