package pl.com.phptravels.core.config;

import pl.com.phptravels.core.driver.BrowserType;

import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class PropertiesReader {
    //browser options
    public static final BrowserType BROWSER_TYPE = Enum.valueOf(
            BrowserType.class,
            retrievePropertyValue("browserType").orElse("CHROME")
    );

    //endpoint defaults
    public static final String BASE_PROTOCOL = retrievePropertyValue("protocol").orElse("https");
    public static final String BASE_HOST = retrievePropertyValue("host").orElse("www.cleartrip.com");

    private static final String PROPERTIES_FILE_PATH = "src/test/resources/application.properties";

    private static Optional<String> retrievePropertyValue(String propertyName) {
        try (FileReader reader = new FileReader(PROPERTIES_FILE_PATH)) {
            Properties properties = new Properties();
            properties.load(reader);
            String propertyValue = properties.getProperty(propertyName);
            return (propertyValue == null || propertyValue.isBlank()) ? Optional.empty() : Optional.of(propertyValue);
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
