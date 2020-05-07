package pl.com.phptravels.test.asserations;

import org.testng.Assert;
import pl.com.phptravels.business.page.ResultsPage;
import pl.com.phptravels.core.base.Assertion;
import pl.com.phptravels.utils.BrowserUtils;

public class SearchFlightAssertions extends Assertion<ResultsPage> {

    public SearchFlightAssertions verifyBar(){
        BrowserUtils.waitFor(page.getResultBar(), 5);
        Assert.assertTrue(page.getResultBar().isDisplayed());
        return this;
    }
}
