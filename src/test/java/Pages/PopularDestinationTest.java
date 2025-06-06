package Pages;

import Utils.Utils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopularDestinationTest {

    private static Utils utils;
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static HomePage homePage;
    private static HotelPage hotelPage;

    @BeforeAll
    public static void setUp() {
        utils = new Utils();
        utils.setupDriver();
        driver = utils.getDriver();
        wait = utils.getWaitTime();
        homePage = new HomePage(driver);
        hotelPage = new HotelPage(driver);
    }
    @Test
    public void popularDestinationScenario() {
        // 1. Кликаем на изображение популярного направления
        homePage.popularDestinationImageClick();

    }

    @AfterAll
    public static void tearDown() {
        if (utils != null) {
            utils.quitDriver();
        }
    }
}
