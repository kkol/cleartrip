package elements.calender;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class DataPicker {
    @Getter
    private WebDriver driver;
    private DataPickerFactory factory;

    public DataPicker(WebDriver driver){
        this.driver = driver;
        factory = new DataPickerFactory(driver);
    }

    public void openDepartOn(){
        factory.getDepartOn().click();
    }
    public void selectDayLeft(int index){
        factory.getDayCalenderFirst().get(index).click();
    }
    public void selectDayRight(int index){
        factory.getDayCalenderSecond().get(index).click();
    }
}
