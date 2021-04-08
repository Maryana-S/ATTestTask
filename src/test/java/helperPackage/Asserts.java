package helperPackage;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;

public class Asserts {
    private static Logger logger = Logger.getLogger(HelperClass.class);

    public static void equalsTo(String expected, String actual, String description) {
        logger.info(description);
        assert expected.equals(actual) : "Значения не эквивалентны";
    }

    public static void equalsTo(String expected, String actual) {
        equalsTo(expected, actual, "Проверка соответствия ожидаемого результата действительному");
    }


    public static void notEqualsTo(String expected, String actual, String description) {
        logger.info(description);
        assert expected != actual : "Значения эквивалентны";
    }

    public static void notEqualsTo(String expected, String actual) {
        notEqualsTo(expected, actual, "Проверка несоответствия ожидаемого результата действительному");
    }


    public static void contains(String result, String content, String description) {
        logger.info(description);
        assert result.contains(content) : "Строка не содержит данную подстроку";
    }

    public static void contains(String result, String content) {
        contains(result, content, "Проверка наличия подстроки в строке");
    }


    public static void notContains(String result, String content, String description) {
        logger.info(description);
        assert !result.contains(content) : "Строка содержит данную подстроку";
    }

    public static void notContains(String result, String content) {
        notContains(result, content, "Проверка отсутствия подстроки в строке");
    }

    public static void more(int var1, int var2, String description) {
        logger.info(description);
        if (var1 > var2) {
            throw new AssertionError("Значение " + var1 + " больше значения " + var2);
        }
    }

    public static void more(int var1, int var2) {
        more(var1, var2, "Проверка того, что значение " + var2 + " больше значения " + var1);

    }

    @Step("Сравнение сначений {num1} и {num2}")
    public static void intEquals(int num1, int num2, String description) {
        if (num1 != num2) {
            throw new AssertionError(description);
        }
    }

    @Step("Сравнение сначений {num1} и {num2}")
    public static void intEquals(int num1, int num2) {
        intEquals(num1, num2, "Значения не равны!");
    }


}
