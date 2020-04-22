package pl.com.phptravels.core.base;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.internal.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.lang.reflect.InvocationTargetException;

public class BasePage implements BaseAssertion {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this(driver, null);
    }

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        if (StringUtils.isNotBlank((url))) {
            driver.navigate().to(url);
        }
        PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);
    }

    @SuppressWarnings("unchecked")
    public <G extends BasePage, T extends Assertion<G>> T check(Class<T> clazz) {
        try {
            T assertion = clazz.getConstructor().newInstance();
            assertion.setPage((G) this);
            return assertion;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Error occur during creating Assertions.", e);
        }
    }

    @SuppressWarnings("unchecked")
    public <I extends BasePage, O extends BasePage> O run(BaseScenario<I, O> scenario) {
        return scenario.run((I) this);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
    public String getTitle(){
        return driver.getTitle();
    }

    /**
     * getParagraph - method returns page copyrightText
     *
     * @return String
     */
    public String getParagraph(String pattern) {
        String locator = "//p[contains(text(), '" + pattern + "') or contains(.,'" + pattern + "')]";
        return driver.findElement(By.xpath(locator)).getText();
    }

    /**
     * selectFrom - method to select element from list
     *
     * @param element     - element which will be selected
     * @param visibleText - it has to have provided visible text in order to be selected
     * @return any page extending Base Page
     */

    public void selectFrom(WebElement element, String visibleText){
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void moveToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }


    ;


}
