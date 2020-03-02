package com.travels.aut.autSubname.ux.framework.utils;

import com.travels.aut.autSubname.ux.framework.driver.CreateDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationWaits {
    public static void waitFor(WebElement element, int seconds) throws Exception {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        WebDriverWait exists = new WebDriverWait(driver, seconds);
        exists.until(ExpectedConditions.refreshed((ExpectedConditions.visibilityOf(element))));
    }

    public static void waitFor(By by, int seconds) throws Exception{
        WebDriver driver = CreateDriver.getInstance().getDriver();
        WebDriverWait exists = new WebDriverWait(driver, seconds);
        exists.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
    }

    public static void waitForGone(By by, int seconds) throws Exception {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        WebDriverWait exists = new WebDriverWait(driver, seconds);
        exists.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(by)));
    }

    public static void waitForURL(String url, int seconds) throws Exception {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        WebDriverWait exists = new WebDriverWait(driver, seconds);
        exists.until(ExpectedConditions.refreshed((ExpectedConditions.urlContains(url))));
    }
}
