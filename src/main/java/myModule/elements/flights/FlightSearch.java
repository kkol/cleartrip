package myModule.elements.flights;

import myModule.elements.setups.BrowserBase;
import org.openqa.selenium.WebElement;

public class FlightSearch<M extends WebElement> extends BrowserBase<M> {
    private String PATE_TITLE = "Title";
    public FlightSearch() throws Exception {
        setPageTitle(PATE_TITLE);
    }

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

    public void searchFlight(){
        
    }


}
