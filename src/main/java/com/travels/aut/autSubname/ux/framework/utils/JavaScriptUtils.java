package com.travels.aut.autSubname.ux.framework.utils;

import com.travels.aut.autSubname.ux.framework.driver.CreateDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {
    public JavaScriptUtils() {

    }

    /**
     * execute - generic method to execute non-parametrized JS command
     * @param command
     */
    public static void execute(String command) {
        WebDriver driver = CreateDriver.getInstance().getDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(command);
    }

    /**
     * execute - overloaded method to execue a JS command on WebElement
     *
     * @param command
     * @param element
     */
    public static void execute(String command, WebElement element) {
        WebDriver driver = CreateDriver.getInstance().getDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(command, element);
    }

    /**
     * click - method to execute a JS click event
     *
     * @param element
     */
    public static void click(WebElement element) {
        WebDriver driver = CreateDriver.getInstance().getDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * click - overloaded method to execute a JS click event using By
     *
     * @param by
     */

    public static void click(By by) {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        WebElement element = driver.findElement(by);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void sendKeys(String keys, WebElement element) {
        WebDriver driver = CreateDriver.getInstance().getDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value ='" + keys + "';", element);
    }

    /**
     * @param driver
     * @return boolean
     */
    public static boolean isPageReady(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript("return document.readyState").equals("complete");
    }

    /**
     *
     * @param driver
     * @return boolean
     */
    public static boolean isAjaxReady(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return (Boolean)js.executeScript("return jQuery.active == 0");
    }



}
