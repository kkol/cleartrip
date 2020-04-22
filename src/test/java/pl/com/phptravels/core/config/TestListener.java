package pl.com.phptravels.core.config;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jsoup.nodes.Element;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import pl.com.phptravels.core.base.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static pl.com.phptravels.core.config.Constants.*;

public class TestListener extends TestListenerAdapter {

    private final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result){
        super.onTestStart(result);
        logger.info("Test started [{}]...", obtainTestMetaData(result));
    }

    @Override
    public void onConfigurationFailure(ITestResult result) {
        super.onConfigurationFailure(result);
        addScreenshotToLog(result);
        logger.info(
                "Configuration failed for test [{}]. Screenshot of the current page made and added to report.",
                obtainTestMetaData(result)
        );
    }

    @Override
    public void onConfigurationSuccess(ITestResult result) {
        super.onConfigurationSuccess(result);
        logger.info("Configuration succeeded for test [{}].", obtainTestMetaData(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        logger.info("Test [{}] succeeded!", obtainTestMetaData(result));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        super.onTestSkipped(result);
        logger.info("Test [{}] skipped!", obtainTestMetaData(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        logger.error(ExceptionUtils.getStackTrace(result.getThrowable()));
        addScreenshotToLog(result);
        logger.info(
                "Test [{}] failed. Screenshot of the current page made and added to report.",
                obtainTestMetaData(result)
        );
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        super.onTestFailedButWithinSuccessPercentage(result);
        addScreenshotToLog(result);
        logger.info(
                "Test [{}] failed but within success percentage. Screenshot of the current page added to the report.",
                obtainTestMetaData(result)
        );
    }



    private void addScreenshotToLog(ITestResult iTestResult) {
        WebDriver driver = ((BaseTest) iTestResult.getInstance()).getDriver();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(constructRelativePath(REPORT_LOG_OUTPUT_PATH, iTestResult)));
            Reporter.log(buildScreenshotHtmlTag(constructRelativePath(LOG_OUTPUT_PATH, iTestResult)));
        } catch (IOException e) {
            logger.error(
                    "There was an error during copying screenshot file [{}] to report output.", screenshot.getName()
            );
        }
    }

    private String buildScreenshotHtmlTag(String location) {
        Element hyperlinkElement = new Element(HYPERLINK_TAG, "")
                .attr(HREF_ATTR, location);
        Element img = new Element(IMG_TAG, "")
                .attr(SRC_ATTR, (location.replace("//", File.separator)))
                .attr(WIDTH_ATTR, "192")
                .attr(HEIGHT_ATTR, "108");
        hyperlinkElement.appendChild(img);
        return hyperlinkElement.toString();
    }

    private String constructRelativePath(String filePath, ITestResult iTestResult){
        return filePath + constructFileName(iTestResult) + SCREENSHOT_EXTENSION;
    }

    private String constructFileName(ITestResult iTestResult) {
        return iTestResult.getInstanceName() + "_" +
                iTestResult.getName() + "_" +
                Arrays.hashCode(iTestResult.getParameters());
    }


    private String obtainTestMetaData(ITestResult result){
        return  result.getTestClass().getRealClass().getName() + "."
                + result.getMethod().getConstructorOrMethod().getMethod().getName() + "()";
    }


}
