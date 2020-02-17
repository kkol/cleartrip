package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class Setup extends CreateCriver
{
    public Setup(){
        super();
    }

    @BeforeTest
    public void beforeTest(){
        Map<String, Object>  preference = new HashMap<>();
        preference.put("profile.default_content_setting_values.notifications", 2);
        super.setDriver("chrome", preference);


      /*  WebDriverManager.chromedriver().setup();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); */
    }



    @AfterTest
    public void afterTest(){
        //driver.quit();
    }

    public void sleep(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
