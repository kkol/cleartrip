package tests;

import com.travels.aut.autSubname.ux.framework.dataprovider.FlightSet;
import com.travels.aut.autSubname.ux.framework.dataprovider.JSONDataProvider;
import myModule.elements.flights.FlightSearch;
import com.travels.aut.autSubname.ux.framework.setups.CommonSetup;
import myModule.setup.PreSetup;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class CleartripTest extends PreSetup {
    private FlightSearch<WebElement> search;

    @Override
    @BeforeClass(alwaysRun = true)
    protected void classSetup(ITestContext context) throws Exception{

    }

    @Override
    @BeforeMethod(alwaysRun = true)
    protected void methodSetup(ITestResult result) throws Exception {
        search = new FlightSearch<>();
        driver.getDriver().get("https://www.cleartrip.com/flights");
    }


/**
 * tc001 - example of using dataprovider, need to improve verification search results before using next dataprovider data set
 * @param testData
 * @throws Exception
 */
/*    @Test(dataProvider = "data-provider", dataProviderClass = JSONDataProvider.class)
    public void tc002(JSONObject testData) throws Exception {
        FlightSet flightSet = new FlightSet(testData);

        if (testData.get("error") == null) {
            search.searchFlight(flightSet.getAirportFrom(), flightSet.getAirportTo(), flightSet.getAdults(), flightSet.getChildrens(),flightSet.getInfants());
        }
        else {
            search.searchFlight(flightSet.getAirportFrom(), flightSet.getAirportTo(), flightSet.getAdults(), flightSet.getChildrens(),flightSet.getInfants(), flightSet.getError());

        }
        Thread.sleep(5000);
    }*/

    @Test
    public void tc001() throws Exception {
        search.searchFlight("Rzeszow, PL - Jasionka (RZE)", "Warsaw, PL - Warsaw (WAW)", "2", "2", "0");
    }

    @Test
    public void tc003() throws Exception {
        search.searchFlight("Rzeszow, PL - Jasionka (RZE)", "Warsaw, PL - Warsaw (WAW)", "2", "2", "0");
    }
}
