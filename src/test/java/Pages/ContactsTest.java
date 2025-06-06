package Pages;

import Utils.Utils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsTest {

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
        homePage.contactsClick();
        // 1. Проверяем основной блок контактов
        WebElement contactsBlock = driver.findElement(
                By.xpath("//div[contains(@class, 'zenaboutcontacts')]")
        );
        Assertions.assertTrue(contactsBlock.isDisplayed(), "Contacts block should be visible");
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
