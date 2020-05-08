package pl.com.phptravels.core.config;

import org.jsoup.parser.Tag;

import static pl.com.phptravels.core.config.PropertiesReader.*;

public class Constants {
    // browser options
    public static final String MAXIMIZED = "--start-maximized";
    public static final String DISABLED_NOTIFICATIONS = "--disable-notifications";
    // url defaults
    public static final String BASE_URL = BASE_PROTOCOL + "://" + BASE_HOST;
    // output defaults
    public static final String REPORT_LOG_OUTPUT_PATH = "target/surefire-reports/log/";
    public static final String LOG_OUTPUT_PATH = "log/";
    public static final String SCREENSHOT_EXTENSION = ".jpg";
    // html defaults
    public static final Tag HYPERLINK_TAG = Tag.valueOf("a");
    public static final Tag IMG_TAG = Tag.valueOf("img");
    public static final String HREF_ATTR = "href";
    public static final String SRC_ATTR = "src";
    public static final String WIDTH_ATTR = "width";
    public static final String HEIGHT_ATTR = "height";
}
