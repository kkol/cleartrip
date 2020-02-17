package tests;

import base.Setup;
import elements.calender.DataPicker;
import elements.flights.Flight;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExampleTest extends Setup{
    private Flight flight;
    private DataPicker dataPicker;

    @Override
    @BeforeTest
    public void beforeTest(){
        super.beforeTest();
        getDriver().get("https://www.cleartrip.com/flights");
        flight = new Flight(getDriver());
        dataPicker = new DataPicker(getDriver());
        getDriver().manage().window().maximize();
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
