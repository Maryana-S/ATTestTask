package tests;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static helperPackage.HelperClass.newDriver;


public class BaseTest {
    Logger logger = Logger.getLogger(getClass());
    WebDriver driver = newDriver();

    @Step("Переход на стартовую страницу Yandex")
    public void openYandex(){
        logger.info("Открывается стартовая страница Yandex");
        driver.get("https://yandex.ru/");

    }

    @Step("Переход на стартовую страницу Google")
    public void openGoogle(){
        logger.info("Открывается стартовая страница Google");
        driver.get("https://www.google.ru/");
    }

    @Step("Открывается стартовая страница Яндекс.Маркет")
    public void openYaMarket(){
        logger.info("Открывается стартовая страница Яндекс.Маркет");
        driver.get("https://market.yandex.ru/");
    }


    @Before
    @Step("Начало теста")
    public void begin(){
        logger.info("Начало теста");
    }


    @After
    @Step("Закрытие браузера, завершение теста")
    public void close(){
        driver.close();
        logger.info("Браузер закрыт, завершение теста");
    }



}
