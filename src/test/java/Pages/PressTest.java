package Pages;

import Utils.Utils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PressTest {

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
    public void pressTestScenario() {
        homePage.pressClick();
        // 1. Проверяем основной блок прессы
        WebElement contactsBlock = driver.findElement(
                By.xpath("//div[contains(@class, 'zenpress')]")
        );
        Assertions.assertTrue(contactsBlock.isDisplayed(), "Contacts block should be visible");
    }

    @AfterAll
    public static void tearDown() {
        if (utils != null) {
            utils.quitDriver();
        }
    }
}
