package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private final String browser = "firefox"; // "chrome" or "firefox"

    public void setupDriver() {
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        driver.manage().window().setSize(new Dimension(1050, 716));
        js = (JavascriptExecutor) driver;
        driver.get("https://ostrovok.ru/");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWaitTime() {
        return wait;
    }

    public JavascriptExecutor getJsExecutor() {
        return js;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
