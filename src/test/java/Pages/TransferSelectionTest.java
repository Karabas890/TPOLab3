package Pages;

import Utils.Utils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferSelectionTest {
    private static Utils utils;
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static HomePage homePage;
    private static TransferPage transferPage;

    @BeforeAll
    public static void setUp() {
        utils = new Utils();
        utils.setupDriver();
        driver = utils.getDriver();
        wait = utils.getWaitTime();
        homePage = new HomePage(driver);
        transferPage = new TransferPage(driver);
    }
    @Test
    public void testSelectTransferScenario() {
        homePage.openTransfers();
        //pause(5000);
        homePage.enterTransferFromInput("Millennium Place Marina");
        //pause(5000);
        homePage.enterTransferToInput();
       // pause(5000);
        homePage.searchTransfers();
        //pause(1000);
        //transferPage.clickComfortSortButton();
        pause(1000);
        transferPage.clickChooseButton();

        // Тут можно добавить проверки, например, на URL или наличие элемента
    }
    private void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Пауза прервана: " + e.getMessage());
        }
    }


    @AfterAll
    public static void tearDown() {
        if (utils != null) {
            utils.quitDriver();
        }
    }
}
