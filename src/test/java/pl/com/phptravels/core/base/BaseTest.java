package pl.com.phptravels.core.base;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pl.com.phptravels.core.driver.CreateDriver;

import static pl.com.phptravels.core.config.Constants.DISABLED_NOTIFICATIONS;
import static pl.com.phptravels.core.config.Constants.MAXIMIZED;
import static pl.com.phptravels.core.config.PropertiesReader.BROWSER_TYPE;

@Getter
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    protected void testSetup(ITestContext context){
        driver = CreateDriver.getInstance().getDriver(BROWSER_TYPE, MAXIMIZED, DISABLED_NOTIFICATIONS);
    }

    @AfterClass(alwaysRun = true)
    protected void testTeardown(ITestContext context){
        driver.quit();
    }
}
