package elements.flights;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
@Setter
public class FlightFactory {
    private WebDriver driver;

    @FindBy(name = "origin")
    WebElement origin;

    @FindBy(name = "destination")
    WebElement destination;

    @FindBy(id = "SearchBtn")
    WebElement search;

    @FindBy(id = "DepartDate")
    WebElement departOn;

    @FindBy(xpath = "//*[@id='ui-id-1']//a")
    List<WebElement> originAirportList;

    @FindBy(xpath = "//ul[@id='ui-id-2']//a")
    List<WebElement> destinationAirportList;

    @FindBy(id = "Adults")
    WebElement adults;

    @FindBy(id = "Childrens")
    WebElement childrens;

    @FindBy(id = "Infants")
    WebElement infants;



    public FlightFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
