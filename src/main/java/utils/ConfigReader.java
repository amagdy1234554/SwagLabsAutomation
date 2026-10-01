package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;

    static {
        try {
            prop = new Properties();
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            prop.load(file);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public String getProperty(String key){
        return prop.getProperty(key);
    }
}