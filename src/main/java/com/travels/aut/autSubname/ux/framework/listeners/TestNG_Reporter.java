package com.travels.aut.autSubname.ux.framework.listeners;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;

public class TestNG_Reporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDir){
        for(ISuite suite : suites) {

        }
    }
}
