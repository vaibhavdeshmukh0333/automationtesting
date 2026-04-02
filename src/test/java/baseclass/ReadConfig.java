package baseclass;

import utilities.FileUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ReadConfig class to read configuration properties from Config.properties file.
 * Uses singleton pattern.
 */
public class ReadConfig {

    private static ReadConfig instance;
    private Properties properties;

    private ReadConfig() {
        properties = new Properties();
        try {
            FileInputStream fis = FileUtil.readFile("src/test/resources/Properties/Config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns singleton instance of ReadConfig.
     * @return ReadConfig instance.
     */
    public static ReadConfig getInstance() {
        if (instance == null) {
            instance = new ReadConfig();
        }
        return instance;
    }

    /**
     * Gets property value by key.
     * @param key Property key.
     * @return Property value.
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Gets base URL.
     * @return Base URL.
     */
    public String getBaseUrl() {
        return getProperty("url");
    }

    /**
     * Gets PLP URL.
     * @return PLP URL.
     */
    public String getPlpUrl() {
        return getProperty("plpUrl");
    }
}
