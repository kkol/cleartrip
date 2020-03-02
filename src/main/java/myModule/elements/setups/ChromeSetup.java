package myModule.elements.setups;


import com.travels.aut.autSubname.ux.framework.utils.Global_VARS;
import com.travels.aut.autSubname.ux.framework.driver.CreateDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * @author kkol
 */

public class ChromeSetup
{
    public int elementWait = Global_VARS.TIMEOUT_ELEMENT;
    public CreateDriver driver = CreateDriver.getInstance();
    public ChromeSetup(){

    }


    @BeforeTest
    public void beforeTest(){
        driver.setDriver("chrome",
                "--start-maximized",
                "--disable-notifications"
                );
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
