package myModule.elements.setups;

import com.travels.aut.autSubname.ux.framework.driver.CreateDriver;
import com.travels.aut.autSubname.ux.framework.utils.Global_VARS;
import com.travels.aut.autSubname.ux.framework.utils.JavaScriptUtils;
import com.travels.aut.autSubname.ux.framework.utils.SynchronizationWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BrowserBase<M extends WebElement> {
    public  int elementWait = Global_VARS.TIMEOUT_ELEMENT;
    public String pageTitle = "";
    WebDriver driver = CreateDriver.getInstance().getDriver();

    public BrowserBase() throws Exception {
        PageFactory.initElements(driver,this);
    }

    public abstract void setElementWait(int elementWait);
    public abstract int getElementWait();
    public abstract void setPageTitle(String pageTitle);
    public abstract String getPageTitle();

    /**
     * getTitle = methot do return the title of the current page
     * @throws Exception
     */
    public String getTitle() throws Exception {
        WebDriver driver = CreateDriver.getInstance().getDriver();

        return driver.getTitle();
    }

    /**
     * getParapgraph - method to return page copyrightText
     * @return String
     * @throws Exception
     */
    public String getParagraph(String pattern) throws Exception {
        WebDriver driver = CreateDriver.getInstance().getDriver();

        String locator = "//p[contains(text(), '"+pattern+"') or contains(.,'"+pattern+"')]";
        return driver.findElement(By.xpath(locator)).getText();
    }

    /**
     * loadPage - metohod to load the pgar URL and sync against WebElement
     * @param pageURL
     * @param element
     * @throws Exception
     */
    public void loadPage(String pageURL, M element) throws Exception {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        driver.navigate().to(pageURL);

        JavaScriptUtils.isPageReady(driver);
        SynchronizationWaits.waitFor(element, Global_VARS.TIMEOUT_MINUTE);
    }

    /**
     * loadPage - overloaded method to load the page URL ans sync
     * @param pageURL
     * @param landingURL
     * @throws Exception
     */

    public void loadPage(String pageURL, String landingURL) throws Exception {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        driver.navigate().to(pageURL);

        JavaScriptUtils.isPageReady(driver);
        SynchronizationWaits.waitForURL(landingURL, Global_VARS.TIMEOUT_MINUTE);
    }



}
