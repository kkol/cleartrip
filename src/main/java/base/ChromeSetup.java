package base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public abstract class ChromeSetup
{
    public CreateDriver driver = CreateDriver.getInstance();
    public ChromeSetup(){

    }


    @BeforeTest
    public void beforeTest(){
        driver.setDriver("chrome", "--start-maximized","--disable-notifications");
    }




    @AfterTest
    public void afterTest(){
        //driver.quit();
    }

    public void sleep(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
