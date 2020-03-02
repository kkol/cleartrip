package tests;

import myModule.elements.setups.ChromeSetup;
import myModule.elements.calender.DataPicker;
import myModule.elements.flights.Flight;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExampleTest extends ChromeSetup {
    private Flight flight;
    private DataPicker dataPicker;

    @Override
    @BeforeTest
    public void beforeTest(){
        super.beforeTest();
        driver.getDriver().get("https://www.cleartrip.com/flights");
        flight = new Flight(driver.getDriver());
        dataPicker = new DataPicker(driver.getDriver());
    }

    @Test
    public void fillFlightData() {
        flight.enterOriginAirport("Rzeszow, PL - Jasionka (RZE)");
        flight.enterDestinationAirport("Warsaw, PL - Warsaw (WAW)");
        dataPicker.openDepartOn();
        dataPicker.selectDayRight(0);
        flight.selectAdults(2);
        flight.selectChildrens(2);
        flight.selectInfants(1);
        flight.pressSearch();



    }

}
