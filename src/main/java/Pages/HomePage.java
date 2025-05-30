package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage extends Page
{
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[contains(@class, 'Control-module__control--34TbT') and .//div[text()='Войти']]")
    private WebElement loginBlock;
    @FindBy(xpath = "//label[contains(@class, 'Input-module__label--1p3o1')]//input[@name='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//label[contains(@class, 'Input-module__label--1p3o1')]//input[@name='pass']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(@class, 'Authorization-module__button--3aF30') and .//div[text()='Войти']]\n")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class='Control-module__username--3qcGq']\n")
    private WebElement emailBlock;

    // Метод: открыть блок входа (клик по loginBlock)
    public void openLoginBlock() {
        loginBlock.click();
    }

    // Метод: заполнить поле email
    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    // Метод: заполнить поле пароль
    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    // Метод: кликнуть по кнопке Войти
    public void clickLoginButton() {
        loginButton.click();
    }

    public String getLoggedInEmail() {
        return emailBlock.getText();
    }



}
