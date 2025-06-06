package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    @FindBy(xpath = "//label[contains(@class, 'Input-module__label') and .//div[text()='Направление']]//input[contains(@class, 'Input-module__control--')]")
    private WebElement destinationInput;
    @FindBy(xpath = "//label[contains(@class, 'Input-module__label') and .//div[text()='Заезд']]//div[contains(@class, 'Input-module__control--')]")
    private WebElement checkInInput;
    // @FindBy(xpath = "//div[@class='Day-module__inner--y2nlD' and @data-day='Thu Jun 06 2025 00:00:00 GMT+0300 (Москва, стандартное время)']")
    @FindBy(xpath = "/html/body/div[13]/div[2]/div[1]/div[3]/div[1]/div[3]/div[4]/div")
    private WebElement dayFiveJune;
    //@FindBy(xpath = "//div[@class='Day-module__inner--y2nlD Day-module__inner_selected--2oS_w Day-module__inner_edgeDay--3bUe- Day-module__inner_withRightRadius--2xFgE' and @data-day='Fri Jun 07 2025 00:00:00 GMT+0300 (Москва, стандартное время)']")
    @FindBy(xpath = "/html/body/div[13]/div[2]/div[1]/div[3]/div[1]/div[3]/div[7]/div")
    private WebElement daySixJuneSelected;
    @FindBy(xpath = "//span[@class='InputRadio-module__icon--CrPvO']")
    private WebElement radioIcon;
    @FindBy(xpath = "//button[contains(@class, 'Button-module__button--MR2Ly') and .//div[text()='Найти']]")
    private WebElement searchButton;
    @FindBy(xpath = "//div[contains(@class, 'EmptySuggest-module__emptySuggestText') and contains(text(), 'Мы не знаем такое место')]")
    private WebElement emptySuggestMessage;
    @FindBy(xpath = "//div[contains(@class, 'Tabs-module__control') and text()='Трансферы']")
    private WebElement transfersTab;
    @FindBy(xpath = "//div[@data-testid='transfer-destination-from' and @role='textbox']")
    private WebElement transferFromInput;
    @FindBy(xpath = "//div[@data-testid='transfer-destination-to' and @role='textbox']")
    private WebElement transferToInput;
    @FindBy(xpath = "//button[contains(@class, 'Button-module__button') and .//div[text()='Найти']]")
    private WebElement searchTransferButton;
    @FindBy(xpath = "//input[@data-testid='transfer-destination-from']")
    private WebElement transferFromInputNew;
    @FindBy(xpath = "//input[@data-testid='transfer-destination-to']")
    private WebElement transferToInputNew;
    @FindBy(xpath = "//div[contains(@class, 'SuggestOption-module__item') and .//p[text()='Отель Millennium Place Marina']]")
    private WebElement placeMarina;
    @FindBy(xpath = "//div[@role=\"button\" and .//p[text()=\"Дубай\"]]")
    private WebElement dubaiOption;
    @FindBy(xpath = "//div[contains(@class, 'SupportWidget-module__control') and .//div[text()='Помощь']]")
    private WebElement helpButton;
    @FindBy(xpath = "//button[contains(@class, 'SupportWidget-module__socialLink') and text()='Чат с поддержкой']")
    private WebElement chatWithSupportButton;
    @FindBy(xpath = "//textarea[@placeholder='Сообщение' and contains(@class, 'sc-jlsrNB')]")
    private WebElement messageTextArea;
    @FindBy(xpath = "//div[@data-testid='language-widget-control']")
    private WebElement languageWidgetControl;
    @FindBy(xpath = "//div[text()='English']")
    private WebElement languageEnglish;
    @FindBy(xpath = "//img[contains(@class, 'PopularDestination__image')]")
    private WebElement popularDestinationImage;
    @FindBy(xpath = "//a[@href='/about/contacts/' and text()='Контакты']")
    private WebElement contacts;
    @FindBy(xpath = "//a[@href='https://career.ostrovok.ru/?utm_source=footer_header' and text()='Компания и команда']")
    private WebElement companyAndTeam;
    @FindBy(xpath = "//a[@href='/about/press/' and text()='Для прессы']")
    private WebElement press;
    @FindBy(xpath = "//a[@href='https://career.ostrovok.ru/vacancy/?utm_source=main_page_footer' and text()='Вакансии']")
    private WebElement vacansies;
    public void companyAndTeamClick() {
        companyAndTeam.click();
    }
    public void pressClick() {
        press.click();
    }
    public void vacansiesClick() {
        vacansies.click();
    }
    public void contactsClick() {
        contacts.click();
    }
    public void popularDestinationImageClick() {
    popularDestinationImage.click();
}
    public String getHomepageBlockTitleText() {
        return driver.findElement(By.className("homepage-block-title")).getText();
    }

    public void clicklanguageEnglish() {
        languageEnglish.click();
    }
    public void clickLanguageWidgetControl() {
        languageWidgetControl.click();
    }

    public void enterMessage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(messageTextArea));
        messageTextArea.click();
        messageTextArea.clear();
        messageTextArea.sendKeys(message);
    }
    @FindBy(xpath = "//div[@data-selector='ReplyButton' and text()='Принять и продолжить']")
    private WebElement acceptAndContinueButton;

    public void clickAcceptAndContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(acceptAndContinueButton));
        acceptAndContinueButton.click();
    }
    // @FindBy для "Да"
    @FindBy(xpath = "//div[@data-selector='ReplyButton' and text()='Да']")
    private WebElement buttonYes;

    // @FindBy для "Документы и справки"
    @FindBy(xpath = "//div[@data-selector='ReplyButton' and text()='Документы и справки']")
    private WebElement buttonDocs;

    // @FindBy для "Получить ваучер"
    @FindBy(xpath = "//div[@data-selector='ReplyButton' and text()='Получить ваучер']")
    private WebElement buttonVoucher;

    // @FindBy для "Понятно 👌"
    @FindBy(xpath = "//div[@data-selector='ReplyButton' and text()='Понятно 👌']")
    private WebElement buttonUnderstood;

    // Методы для клика:
    public void clickButtonYes() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonYes));
        buttonYes.click();
    }

    public void clickButtonDocs() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonDocs));
        buttonDocs.click();
    }

    public void clickButtonVoucher() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonVoucher));
        buttonVoucher.click();
    }

    public void clickButtonUnderstood() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonUnderstood));
        buttonUnderstood.click();
    }





    public void clickHelpButton() {
        helpButton.click();
    }
    public void clickChatWithSupport() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(chatWithSupportButton)).click();
    }


    public void openTransfers() {
        transfersTab.click();
    }
    public void enterTransferFromInput(String destination) {
        transferFromInput.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(transferFromInputNew)); // дождаться input
        transferFromInputNew.clear();
        transferFromInputNew.sendKeys(destination);
        wait.until(ExpectedConditions.visibilityOf(placeMarina)); // или другого элемента-подсказки
        placeMarina.click();
        //transferFromInputNew.sendKeys(Keys.ENTER);  // нажать Enter после ввода
    }
    public void textTransferFromInput(String destination) {
        transferFromInput.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(transferFromInputNew)); // дождаться input
        transferFromInputNew.clear();
        transferFromInputNew.sendKeys(destination);
    }
    public void enterTransferToInput() {
        transferToInput.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(transferToInputNew)); // дождаться input
        dubaiOption.click();
    }
    public void textTransferToInput(String destination) {
        transferToInput.clear();
        transferToInput.sendKeys(destination);
    }
    public void searchTransfers() {
        searchTransferButton.click();
    }



    public void enterDestination(String destination) {
        destinationInput.clear();
        destinationInput.sendKeys(destination);
        destinationInput.sendKeys(Keys.ENTER);  // нажать Enter после ввода
    }
    public void textDestination(String destination) {
        destinationInput.clear();
        destinationInput.sendKeys(destination);
    }

    public void openCheckInCalendar() {
        checkInInput.click();
    }

    public void selectStartDate() {
        dayFiveJune.click();
    }

    public void selectEndDate() {
        daySixJuneSelected.click();
    }

    public void selectRadioIcon() {
        radioIcon.click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }
    public boolean isEmptySuggestVisible() {
        return emptySuggestMessage.isDisplayed();
    }

    public String getEmptySuggestText() {
        return emptySuggestMessage.getText();
    }

    // Общий метод, который выполняет все шаги по порядку
    public void fillSearchFormAndSubmit(String destination) {
        enterDestination(destination);
        openCheckInCalendar();
        selectStartDate();
        selectEndDate();
        selectRadioIcon();
        clickSearchButton();
    }








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
