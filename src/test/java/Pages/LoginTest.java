package Pages;
import Utils.Utils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

    private static Utils utils;
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static HomePage homePage;

    @BeforeAll
    public static void setUp() {
        utils = new Utils();
        utils.setupDriver();
        driver = utils.getDriver();
        wait = utils.getWaitTime();
        homePage = new HomePage(driver);
    }

    @Test
    @Order(1)
    public void invalidLoginTest() {
        homePage.openLoginBlock();

        // Ждём появления полей
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass")));

        // Пустые поля или невалидный ввод
        homePage.enterEmail("invalid@mail.ru");
        homePage.enterPassword("wrongpassword");
        homePage.clickLoginButton();

        // Ждём появления блока с ошибкой
        By errorLocator = By.className("Authorization-module__error--17cEq");
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));

        // Проверяем, что текст ошибки соответствует ожидаемому
        String errorText = driver.findElement(errorLocator).getText();
        Assertions.assertEquals("Указан неправильный пароль или электронный адрес", errorText);
    }

    @Test
    @Order(2)
    public void validLoginTest() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass")));

        homePage.enterEmail("ivan.mitichev@mail.ru"); // замените на ваш валидный email
        homePage.enterPassword("QL4PrMVPtQkXbPW");    // замените на валидный пароль
        homePage.clickLoginButton();

        // Ждём появления блока с email после логина
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("Control-module__username--3qcGq")
        ));

        // Проверяем, что отображается корректный email
        String actualEmail = homePage.getLoggedInEmail();
        Assertions.assertEquals("ivan.mitichev@mail.ru", actualEmail);
    }

    @AfterAll
    public static void tearDown() {
        if (utils != null) {
            utils.quitDriver();
        }
    }
}