package base;

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
import org.openqa.selenium.remote.RemoteWebDriver;


@Setter @Getter
@SuppressWarnings("varargs")
public class CreateDriver {
    private static CreateDriver instance =  null;
    private WebDriver driver;
    private String browserHandle = null;
    private ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();
    private ThreadLocal<String> sessionId = new ThreadLocal<>();
    private ThreadLocal<String> sessionBrowser = new ThreadLocal<>();
    private ThreadLocal<String> sessionPlatform = new ThreadLocal<>();
    private ThreadLocal<String> sessionVersion = new ThreadLocal<>();


    public static CreateDriver getInstance() {
    if(instance == null){
        instance = new CreateDriver();
    }
    return instance;
    }

    @SafeVarargs
    public final void setDriver(String browser, String...options){
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case  "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(options);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "internet explorer":
                InternetExplorerDriverManager.iedriver().setup();
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                driver = new InternetExplorerDriver();
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
