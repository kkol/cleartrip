package myModule.elements.calender;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
@Setter
public class DataPickerFactory {
    private WebDriver driver;

    @FindBy(id = "DepartDate")
    WebElement departOn;

    @FindBy(xpath = "//*[@id = 'ui-datepicker-div']//*[@class = 'monthBlock first']//span[@class = 'ui-datepicker-month']")
    WebElement calenderFirstHeaderMonth;

    @FindBy(xpath = "//*[@id = 'ui-datepicker-div']//*[@class = 'monthBlock first']//span[@class = 'ui-datepicker-year']")
    WebElement calenderFirstHeaderYear;

    @FindBy(xpath = "//*[@id = 'ui-datepicker-div']//*[@class = 'monthBlock first']//table//tbody//td[@data-handler = 'selectDay']//a")
    List<WebElement> dayCalenderFirst;

    @FindBy(xpath = "//*[@id = 'ui-datepicker-div']//*[@class = 'mmonthBlock last']//span[@class = 'ui-datepicker-month']")
    WebElement calenderSecondHeaderMonth;

    @FindBy(xpath = "//*[@id = 'ui-datepicker-div']//*[@class = 'monthBlock last']//span[@class = 'ui-datepicker-year']")
    WebElement calenderSecondHeaderYear;

    @FindBy(xpath = "//*[@id = 'ui-datepicker-div']//*[@class = 'monthBlock last']//table//tbody//td[@data-handler = 'selectDay']//a")
    List<WebElement> dayCalenderSecond;


    public DataPickerFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
