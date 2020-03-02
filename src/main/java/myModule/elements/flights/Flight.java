package myModule.elements.flights;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Flight {
    @Getter
    private WebDriver driver;
    private FlightFactory factory;

    public Flight(WebDriver driver){
        this.driver = driver;
        factory = new FlightFactory(driver);
    }

    public void enterOriginAirport(String value){
        factory.getOrigin().sendKeys(value);
    }

    public void enterDestinationAirport(String value){
        factory.getDestination().sendKeys(value);
    }

    public void enterDate(String value){
        factory.getDepartOn().sendKeys(value);
    }

    public void pressSearch(){
        factory.getSearch().click();
    }

    public void selectOriginAirport(int index){
        factory.getOriginAirportList().get(index).click();
    }
    public void selectAdults(int adultsNumber){
        Select number = new Select(factory.getAdults());
        number.selectByVisibleText(String.valueOf(adultsNumber));
    }

    public void selectChildrens(int childsNumber){
        Select number = new Select(factory.getChildrens());
        number.selectByVisibleText(String.valueOf(childsNumber));
    }

    public void selectInfants(int infantsNumber){
        Select number = new Select(factory.getInfants());
        number.selectByVisibleText(String.valueOf(infantsNumber));
    }








}
