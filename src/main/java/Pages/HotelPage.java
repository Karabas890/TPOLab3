package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPage extends Page {
    public HotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[contains(@class, 'zenformselect-inner')]//p[contains(@class, 'zenformselect-value')]")
    private WebElement sortOption;
    @FindBy(xpath = "//li[contains(@class, 'zendropdownlist-item-price.desc') and @data-name='price.desc']")
    private WebElement sortByExpensiveItem;
    @FindBy(xpath = "//div[@class=\"hotel-wrapper hotel-wrapper-v2\"]")
    private WebElement hotelDetailsButton;
    public void openSortDropdown() {
        sortOption.click();
    }

    public void selectSortByExpensive() {
        sortByExpensiveItem.click();
    }

    public void clickHotelDetails() {
        hotelDetailsButton.click();
    }

    // Общий метод для последовательного выполнения действий
    public void sortByExpensiveAndOpenDetails() {
        openSortDropdown();
        selectSortByExpensive();
        //clickHotelDetails();
    }




}
