package helperPackage;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelperClass {
    private static Logger logger = Logger.getLogger(HelperClass.class);

    @Step("Инициализация веб драйвера")
    public static WebDriver newDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        logger.info("Запущен браузер");
        return driver;
    }
}
