package pl.com.phptravels.business.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pl.com.phptravels.core.base.BasePage;

@Getter
public class SearchFlightPage extends BasePage {

    @CacheLookup
    @FindBy(name = "origin")
    protected WebElement airportFromInput;

    @CacheLookup
    @FindBy(name = "destination")
    protected WebElement airportToInput;

    @CacheLookup
    @FindBy(id = "DepartDate")
    protected WebElement departDataPicker;

    @CacheLookup
    @FindBy(id = "Adults")
    protected WebElement adultsNumberSelect;

    @CacheLookup
    @FindBy(id = "Childrens")
    protected WebElement childrenNumberSelect;

    @CacheLookup
    @FindBy(id = "Infants")
    protected WebElement infantsNumberSelect;

    @CacheLookup
    @FindBy(id = "SearchBtn")
    protected WebElement searchButton;

    public SearchFlightPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public SearchFlightPage clearAndSetAirportFrom(String airport){
        airportFromInput.clear();
        airportFromInput.sendKeys(airport);
        return this;
    }

    public SearchFlightPage clearAndSetAirportTo(String airport){
        airportToInput.clear();
        airportToInput.sendKeys(airport);
        return this;
    }

    public SearchFlightPage setDepartDate(String date){
        departDataPicker.sendKeys(date);
        return this;
    }

    public SearchFlightPage setAdultsNumber(int number){
        selectFrom(adultsNumberSelect, String.valueOf(number));
        return this;
    }

    public SearchFlightPage setChildrenNumber(int number){
        selectFrom(childrenNumberSelect, String.valueOf(number));
        return this;
    }

    public SearchFlightPage setInfantNumber(int number){
        selectFrom(infantsNumberSelect, String.valueOf(number));
        return this;
    }

    public ResultsPage searchFlights(){
        searchButton.click();
        return new ResultsPage(driver);
    }



}
