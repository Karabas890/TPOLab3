package Pages;

import Utils.Utils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpTest {

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
    public void testSelectHotelScenario() {
        homePage.clickHelpButton();
        //homePage.clickChatWithSupport();
        //homePage.enterMessage("Хочу кушац");
        //homePage.clickButtonUnderstood();
        //homePage.clickButtonDocs();
        //homePage.clickButtonVoucher();
        //homePage.clickButtonYes();
    }

    @AfterAll
    public static void tearDown() {
        if (utils != null) {
            utils.quitDriver();
        }
    }
}
