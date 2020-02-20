package base;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public abstract class ChromeSetup extends CreateDriver
{
    public ChromeSetup(){
        super();
    }


    @BeforeTest
    public void beforeTest(){
        setDriver("chrome", "--start-maximized","--disable-notifications");
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
