package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    static Properties prop = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }
            prop.load(input);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        return prop.getProperty(key);
    }
    public static int getInt(String key) {
        return Integer.parseInt(getProperty(key));
    }
    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(getProperty(key));
    }

}
