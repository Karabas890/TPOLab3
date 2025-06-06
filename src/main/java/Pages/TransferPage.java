package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferPage extends Page {
    public TransferPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[contains(@class, 'Sorting_sortButtonFocus') and .//p[text()='Больше комфорта']]\n")
    private WebElement comfortSortButton;
    @FindBy(xpath = "//button[contains(@class, 'OfferCard_submitButton') and .//div[text()='Выбрать']]")
    private WebElement chooseButton;
    public void clickComfortSortButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(comfortSortButton))
                .click();
    }

    public void clickChooseButton() {
        chooseButton.click();
    }






}
