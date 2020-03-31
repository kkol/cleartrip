package tests;

import com.travels.aut.autSubname.ux.framework.dataprovider.FlightSet;
import com.travels.aut.autSubname.ux.framework.dataprovider.JSONDataProvider;
import myModule.elements.flights.FlightSearch;
import myModule.setup.CommonSetup;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class CleartripTest extends CommonSetup {
    private FlightSearch<WebElement> search;
    //implement abstract method
    @Override
    @BeforeClass(alwaysRun = true, enabled = true)
    protected void testClassSetup(ITestContext context) throws Exception {
        search = new FlightSearch<>();
    }

    @Override
    @AfterClass(alwaysRun = true, enabled = true)
    protected void testClassTeardown(ITestContext context) throws Exception {

    }

    @Override
    @BeforeMethod(alwaysRun = true, enabled = true)
    protected void testMethodSetup(ITestResult result) throws Exception {

    }

    @Override
    @AfterMethod(alwaysRun = true, enabled = true)
    protected void testMethodTeardown(ITestResult result) throws Exception {

    }

    @Override
    @BeforeClass(alwaysRun = true, enabled = true)
    protected void classSetup(ITestContext context) throws Exception {

    }

    @Override
    @AfterClass(alwaysRun = true, enabled = true)
    protected void classTeardown(ITestContext context) throws Exception {

    }

    @Override
    @BeforeMethod(alwaysRun = true, enabled = true)
    protected void methodSetup(ITestResult result) throws Exception {

    }

    @Override
    @AfterMethod(alwaysRun = true, enabled = true)
    protected void methodTeardown(ITestResult result) throws Exception {

    }

/**
 * tc001 - example of using dataprovider, need to improve verification search results before using next dataprovider data set
 * @param testData
 * @throws Exception
 */
    @Test(dataProvider = "data-provider", dataProviderClass = JSONDataProvider.class)
    public void tc001(JSONObject testData) throws Exception {
        FlightSet flightSet = new FlightSet(testData);

        driver.getDriver().get("https://www.cleartrip.com/flights");
        search.searchFlight(flightSet.getAirportFrom(), flightSet.getAirportTo(), flightSet.getAdults(), flightSet.getChildrens(),flightSet.getInfants());
        Thread.sleep(5000);
        driver.getDriver().navigate().back();



    }
}
