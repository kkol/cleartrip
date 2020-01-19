package elements.flights;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Flight {
    @Getter
    private WebDriver driver;
    private FlightFactory factory;

    public Flight(WebDriver driver){
        this.driver = driver;
        factory = new FlightFactory(driver);
    }

    public void enterOrigin(String value){
        factory.getOrigin().sendKeys(value);
    }

    public void enterDestination(String value){
        factory.getDestination().sendKeys(value);
    }
    public  void enterDate(String value){
        factory.getDepartOn().sendKeys(value);
    }

    public void pressSearch(){
        factory.getSearch().click();
    }

    public void getAirportSize(){
        factory.getOriginAirportList().get(0).click();
    }






}
