package com.travels.aut.autSubname.ux.framework.utils;

import com.travels.aut.autSubname.ux.framework.driver.CreateDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
    public static boolean elementExists(WebElement element, int timer){
        try{
            WebDriver driver = CreateDriver.getInstance().getDriver();
            WebDriverWait exists = new WebDriverWait(driver,timer);

            exists.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
            return true;
        }
        catch (StaleElementReferenceException | TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public static void waitFor(String title, int timer) throws Exception {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        WebDriverWait exists = new WebDriverWait(driver, timer);

        exists.until(ExpectedConditions.refreshed(ExpectedConditions.titleContains(title)));
    }


}
