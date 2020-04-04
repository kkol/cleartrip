package myModule.elements.flights;

import com.travels.aut.autSubname.ux.framework.utils.BrowserUtils;
import com.travels.aut.autSubname.ux.framework.utils.Global_VARS;
import lombok.Getter;
import com.travels.aut.autSubname.ux.framework.setups.BrowserBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

@Getter
public class FlightSearch<M extends WebElement> extends BrowserBase<M> {
    private String PATE_TITLE = "Title";

    public FlightSearch() throws Exception {
        super();
        setPageTitle(PATE_TITLE);
    }


    @FindBy(name = "origin")
    @CacheLookup
    protected M origin;

    @FindBy(name = "destination")
    @CacheLookup
    protected M destination;

    @FindBy(id = "SearchBtn")
    @CacheLookup
    protected M search;

    @FindBy(id = "DepartDate")
    @CacheLookup
    protected M departOn;

    @FindBy(xpath = "//*[@id='ui-id-1']//a")
    @CacheLookup
    protected List<M> originAirportList;

    @FindBy(xpath = "//ul[@id='ui-id-2']//a")
    @CacheLookup
    protected List<M> destinationAirportList;

    @FindBy(id = "Adults")
    @CacheLookup
    protected M adults;

    @FindBy(id = "Childrens")
    @CacheLookup
    protected M childrens;

    @FindBy(id = "Infants")
    @CacheLookup
    protected M infants;

    @FindBy(id = "homeErrorMessage")
    @CacheLookup
    protected M error;

    @Override
    public void setElementWait(int elementWait) {
        this.elementWait = elementWait;
    }

    @Override
    public int getElementWait() {
        return this.elementWait;
    }

    @Override
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    @Override
    public String getPageTitle() {
        return this.pageTitle;
    }

    /**
     * searchFlight - general method to search a flight
     *
     * @param arrivalAirport
     * @param departureAirport
     * @throws Exception
     */
    public void searchFlight(String arrivalAirport, String departureAirport, String adult, String children, String infant) throws Exception {
        this.origin.sendKeys(arrivalAirport);
        this.destination.sendKeys(departureAirport);
        this.departOn.click();
        this.departOn.sendKeys(Keys.ENTER);
        this.selectFrom(adults, adult);
        this.selectFrom(childrens, children);
        this.selectFrom(infants, infant);
        this.search.click();


        if (BrowserUtils.elementExists(error, Global_VARS.TIMEOUT_ELEMENT / 2)) {
            String getError = error.getText();
            throw new Exception("Flight searching ends with error: " + getError);
        }
    }

    /**
     * searchFlight - overriden method to negative testing - later need to be discussed if this aproach will be use in future
     * @param message
     * @throws Exception
     */
    public void searchFlight(String arrivalAirport, String departureAirport, String adult, String children, String infant, String message) throws Exception {
        this.origin.sendKeys(arrivalAirport);
        this.destination.sendKeys(departureAirport);
        this.departOn.click();
        this.departOn.sendKeys(Keys.ENTER);
        this.selectFrom(adults, adult);
        this.selectFrom(childrens, children);
        this.selectFrom(infants, infant);
        this.search.click();

        throw new Exception(message);
    }

    public FlightSearch getFlight(String arrivalAirport) throws Exception {
       origin.sendKeys(arrivalAirport);
       return this;
    }

        /**
         * verifySearchLogo - checks if logo is displayed
         */
        public void verifySearchLogo () {
            Assert.assertTrue(cleartripLogo.isDisplayed());
        }


    }
