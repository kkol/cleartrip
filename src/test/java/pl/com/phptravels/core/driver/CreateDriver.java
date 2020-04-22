package pl.com.phptravels.core.driver;

import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;


@Getter @Setter
public class CreateDriver {
    private static CreateDriver instance = null;
    private WebDriver driver;

    public static CreateDriver getInstance() {
        if (instance == null) {
            instance = new CreateDriver();
        }
        return instance;
    }

    public WebDriver getDriver(BrowserType type, String... options) {
        switch (type) {
            case FIREFOX:
                driver = getFirefoxDriver(options);
                break;
            case IE:
                driver = getInternetExplorerDriver();
                break;
            case CHROME:
            default:
                driver = getChromeDriver(options);
        }
        return driver;
    }

    private WebDriver getFirefoxDriver(String... options) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions().addArguments(options);
        return new FirefoxDriver(firefoxOptions);
    }

    private WebDriver getInternetExplorerDriver() {
        InternetExplorerDriverManager.iedriver().setup();
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        return new InternetExplorerDriver(ieOptions);
    }

    private WebDriver getChromeDriver(String... options) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions().addArguments(options);
        return new ChromeDriver(chromeOptions);
    }
}
