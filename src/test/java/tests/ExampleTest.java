package tests;

import base.Setup;
import elements.flights.Flight;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExampleTest extends Setup{
    private Flight flight;

    @Override
    @BeforeTest
    public void beforeTest(){
        super.beforeTest();
        driver.get("https://www.cleartrip.com/flights");
        flight = new Flight(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void fillFlightData() {
        flight.enterOrigin("Rzeszow, PL - Jasionka (RZE)");
        flight.enterDestination("Warsaw, PL - Warsaw (WAW)");
        flight.enterDate("Wed, 22 Jan, 2020");
    }

}
