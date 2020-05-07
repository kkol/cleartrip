package pl.com.phptravels.business.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pl.com.phptravels.core.base.BasePage;

@Getter
public class ResultsPage extends BasePage {

    @CacheLookup
    @FindBy(className = "searchSummary")
    protected WebElement resultBar;

    public ResultsPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public ResultsPage(WebDriver driver) {
        super(driver);
    }
}
