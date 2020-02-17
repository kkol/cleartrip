package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.formula.ptg.ScalarConstantPtg;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Map;


@Setter @Getter
public class CreateCriver {
    private WebDriver driver;
    private String browserHandle = null;
    private ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();
    private ThreadLocal<String> sessionId = new ThreadLocal<>();
    private ThreadLocal<String> sessionBrowser = new ThreadLocal<>();
    private ThreadLocal<String> sessionPlatform = new ThreadLocal<>();
    private ThreadLocal<String> sessionVersion = new ThreadLocal<>();

    @SafeVarargs
    public final void setDriver(String browser, Map<String, Object>...optPreferences){
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("prefs", optPreferences);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case  "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("prefs", optPreferences);
                driver = new ChromeDriver(chromeOptions);
                break;
        }


    }
    public void setDriver(WebDriver driver){
        webdriver.set(driver);
        sessionId.set(((RemoteWebDriver) webdriver.get()).getSessionId().toString());
        sessionBrowser.set(((RemoteWebDriver)webdriver.get()).getCapabilities().getBrowserName());
        sessionPlatform.set(((RemoteWebDriver)webdriver.get()).getCapabilities().getPlatform().toString());
        setBrowserHandle(webdriver.get().getWindowHandle());
    }
}
