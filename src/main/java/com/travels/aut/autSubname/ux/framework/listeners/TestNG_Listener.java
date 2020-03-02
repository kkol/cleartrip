package com.travels.aut.autSubname.ux.framework.listeners;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNG_Listener extends TestListenerAdapter {
    @Override
    public void onStart(ITestContext testContext) {
        try {
            log("Suite Start Date: " +
                    new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss")
                            .format(new Date()) +
                    ".log");
        } catch (Exception e){
            e.printStackTrace();
        }

        super.onStart(testContext);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        try {
            log("Total Passed = " +
                    getPassedTests().size() +
                    ", Total Failed = " +
                    getFailedTests().size() +
                    ", Total Skipped = " +
                    getSkippedTests().size() +
                    "\n");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        super.onFinish(testContext);
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        try {
            log("***Result = PASSED");
            log(testResult.getEndMillis(),
                    "TEST -> " +
                            testResult.getInstanceName() +
                            "." +
                            testResult.getName());
            log("\n");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        super.onTestSuccess(testResult);
    }

    public void log(long date, String dataLine) throws Exception {
        System.out.format("%s%n", String.valueOf(new Date(date)), dataLine);
    }

    public void log(String dataLine) throws Exception {
        System.out.format("%s%n", dataLine);
    }


}
