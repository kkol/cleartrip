package com.travels.aut.autSubname.ux.framework.dataprovider;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONDataProvider {
    public static String dataFile = "";
    public static String testCaseName = "NA";

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod(Method method) throws Exception {
        Object rowID, description;
        Object[][] result;

        JSONArray testDataArray = (JSONArray) extractData_JSON("dp.json").get(method.getName());
        List<JSONObject> testDataList = new ArrayList<JSONObject>();

        for (int i = 0; i < testDataArray.size() ; i++) {
            testDataList.add((JSONObject) testDataArray.get(i));
        }
        //inclute filter
        if(System.getProperty("includePattern") != null){
            String include = System.getProperty("includePattern");
            List<JSONObject> newList = new ArrayList<>();
            List<String> tests = Arrays.asList(include.split(",",-1));

            for(String getTest : tests){
                for(int i =0; i<testDataList.size();i++){
                    if(testDataList.get(i).toString().contains(getTest)){
                        newList.add(testDataList.get(i));
                    }
                }
            }
        }
        //exclude filter
        if(System.getProperty("excludePattern") != null){
            String exclude = System.getProperty("excludePattern");
            List<String> tests = Arrays.asList(exclude.split(",", -1));
            for(String getTest : tests){
                for(int i = testDataList.size() -1; i >=0; i--){
                    if(testDataList.get(i).toString().contains(getTest)){
                        testDataList.remove(testDataList.get(i));
                    }
                }
            }
        }
        result = new Object[testDataList.size()][testDataList.get(0).size()];

        for(int i = 0; i<testDataList.size(); i++){
            result[i] = new Object[]{testDataList.get(i)};
        }

        return result;
    }




    public static JSONObject extractData_JSON(String file) throws Exception {
        FileReader reader = new FileReader(file);
        JSONParser jsonParser = new JSONParser();

        return (JSONObject) jsonParser.parse(reader);
    }

    public static JSONArray fetchData(String file, String filter) throws Exception {
        JSONArray testData = (JSONArray)extractData_JSON(file).get(filter);
        return testData;
    }
}
