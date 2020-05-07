package pl.com.phptravels.test.asserations;

import org.testng.Assert;
import pl.com.phptravels.business.page.ResultsPage;
import pl.com.phptravels.core.base.Assertion;

public class SearchFlightAssertions extends Assertion<ResultsPage> {

    public SearchFlightAssertions verifyBar(){
        Assert.assertTrue(page.getResultBar().isDisplayed());
        return this;
    }
}
