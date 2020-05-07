package pl.com.phptravels.test.tests;

import org.testng.annotations.Test;
import pl.com.phptravels.annotations.TestCase;
import pl.com.phptravels.business.model.FlightData;
import pl.com.phptravels.business.page.SearchFlightPage;
import pl.com.phptravels.business.scenario.SearchFlightScenario;
import pl.com.phptravels.core.base.BaseTest;
import pl.com.phptravels.test.asserations.SearchFlightAssertions;

public class SearchFlightTest extends BaseTest {
    FlightData flightData = new FlightData("Rzeszow, PL - Jasionka (RZE)","Warsaw, PL - Warsaw (WAW)","31/12/2021",2,2,1);
    @TestCase(id = "TC!")
    @Test(description = "")
    public void verifyIfAllWorks(){
        new SearchFlightPage(getDriver(), "https://www.cleartrip.com")
                .run(new SearchFlightScenario(flightData))
                .check(SearchFlightAssertions.class)
                .verifyBar()
                .endAssertion();
    }
}
