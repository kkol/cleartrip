package pl.com.phptravels.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.com.phptravels.core.driver.CreateDriver;

public class BrowserUtils {
    private BrowserUtils() {
    }

    public static boolean elementExists(WebElement element, int timer) {
        try {
            WebDriver driver = CreateDriver.getInstance().getDriver();
            WebDriverWait wait = new WebDriverWait(driver, timer);
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
            return true;
        } catch (StaleElementReferenceException | TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public static void waitFor(String title, int timer) {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        WebDriverWait wait = new WebDriverWait(driver, timer);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.titleContains(title)));
    }

    public static void waitFor(WebElement element, int seconds) {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }

    public static void waitFor(By by, int seconds) {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
    }

    public static void waitForGone(By by, int seconds) {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(by)));
    }

    public static void waitForURL(String url, int seconds) {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.refreshed((ExpectedConditions.urlContains(url))));
    }
}
