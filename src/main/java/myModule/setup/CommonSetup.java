package myModule.setup;


import com.travels.aut.autSubname.ux.framework.utils.Global_VARS;
import com.travels.aut.autSubname.ux.framework.driver.CreateDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

/**
 * @author kkol
 */

public abstract class CommonSetup {

    protected abstract void testClassSetup(ITestContext context) throws Exception;

    protected abstract void testClassTeardown(ITestContext context) throws Exception;

    protected abstract void testMethodSetup(ITestResult result) throws Exception;

    protected abstract void testMethodTeardown(ITestResult result) throws Exception;


    public int elementWait = Global_VARS.TIMEOUT_ELEMENT;
    public CreateDriver driver = CreateDriver.getInstance();



    @BeforeSuite(alwaysRun = true, enabled = true)
    protected void suiteSetup(ITestContext context) throws Exception {

    }

    @AfterSuite(alwaysRun = true, enabled = true)
    protected void suiteTeardown(ITestContext context) throws Exception {

    }


    @BeforeTest(alwaysRun = true, enabled = true)
    protected void testSetup() throws Exception {
        CreateDriver.getInstance().setDriver("chrome", "--start-maximized",
                "--disable-notifications");
    }

    @AfterTest(alwaysRun = true, enabled = true)
    protected void testTeardown(ITestContext context) throws Exception {
        CreateDriver.getInstance().getDriver().close();
    }


    ///there method override the Superclass methods
    @BeforeClass(alwaysRun = true, enabled = true)
    protected void classSetup(ITestContext context) throws Exception{

    }

    @AfterClass(alwaysRun = true, enabled = true)
    protected void classTeardown(ITestContext context) throws Exception{

    }

    @BeforeMethod(alwaysRun = true, enabled = true)
    protected void methodSetup(ITestResult result) throws Exception {

    }

    @AfterMethod(alwaysRun = true, enabled = true)
    protected void methodTeardown(ITestResult result) throws Exception{

    }



}
