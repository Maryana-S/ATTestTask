package tests;

import helperPackage.Asserts;
import helperPackage.JDBCHelper;
import io.qameta.allure.Description;
import org.apache.log4j.Logger;
import org.junit.Test;
import pages.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static helperPackage.Asserts.intEquals;

public class Zad2Test extends BaseTest {
    Logger logger = Logger.getLogger(getClass());

    @Test
    @Description(value = "Поисковой запрос НЕ содержащий рекламу в яндекс")
    public void tc1() {
        openYandex();
        YStartPage yStartPage = new YStartPage(driver);
        YResultPage yResultPage = new YResultPage(driver);
        yStartPage.search("россия");
        String nadF = yResultPage.getSubtitle();

        Asserts.notContains(nadF, "реклама", "Проверка, является ли первый найденный результат рекламой");

    }

    @Test
    @Description(value = "Поисковой запрос возвращает в Google больше результатов, чем в Yandex")
    public void tc2() {
        String request = "желтый";
        openYandex();
        YStartPage yStartPage = new YStartPage(driver);
        YResultPage yResultPage = new YResultPage(driver);
        yStartPage.search(request);
        int yaSearchResult = yResultPage.yaCount();
        System.out.println(yaSearchResult);

        openGoogle();
        GStartPage gStartPage = new GStartPage(driver);
        GResultPage gResultPage = new GResultPage(driver);
        gStartPage.search(request);
        int gSearchResult = gResultPage.gCount();
        System.out.println(gSearchResult);

        Asserts.more(yaSearchResult, gSearchResult, "Проверка того, что количество найденных результатов в Google, больше количества найденных результатов в Yandex");

    }

    @Test
    @Description(value = "Поисковой запрос с рекламой и в Google и в Yandex")
    public void tc3() {
        String request = "clinique";
        openYandex();
        YStartPage yStartPage = new YStartPage(driver);
        YResultPage yResultPage = new YResultPage(driver);
        yStartPage.search(request);
        String yaAd = yResultPage.yaGetSiteTitle();

        openGoogle();
        GStartPage gStartPage = new GStartPage(driver);
        GResultPage gResultPage = new GResultPage(driver);
        gStartPage.search(request);
        String gAd = gResultPage.gGetSiteTitle();

        System.out.println(yaAd);
        System.out.println(gAd);


        Asserts.equalsTo(yaAd, gAd, "Сравнение ссылок первого рекламного запроса в Yandex и Google");
    }

    @Test
    @Description(value = "Проверка соответствия цены товара")
    public void tc4() throws InterruptedException {

        String request = "hempz koa";
        openYaMarket();
        YaMarketStartPage yaMarketStartPage = new YaMarketStartPage(driver);
        YaMarketResultPage yaMarketResultPage = new YaMarketResultPage(driver);
        YaMarketProdactCardPage yaMarketProdactCardPage = new YaMarketProdactCardPage(driver);
        yaMarketStartPage.search(request);

        Thread.sleep(1000);
        yaMarketResultPage.switchView();

        Thread.sleep(1000);
        int rpPrice = yaMarketResultPage.resultPageCost();
        yaMarketResultPage.productCard();

        int pcPrice = yaMarketProdactCardPage.prodactCardCost();

        intEquals(rpPrice, pcPrice, "Сравнение цены на странице 'результаты поиска' и 'карточка продукта'");

    }

    @Test
    @Description(value = "Запрос к бд")
    public void tc5() throws SQLException {
        List<String> res = new ArrayList<>();

        JDBCHelper jbdc = new JDBCHelper();

        res = jbdc.executeSQL("select Name from product");
        for (String s : res) {
            System.out.println(s);
        }


    }


}
