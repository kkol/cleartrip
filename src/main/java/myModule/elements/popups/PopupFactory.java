package myModule.elements.popups;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public class PopupFactory {
    private WebDriver driver;

    @FindBy(name = "q")
    WebElement element;


    public PopupFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}