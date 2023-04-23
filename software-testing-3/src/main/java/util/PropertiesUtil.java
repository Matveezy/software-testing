package util;

import java.io.IOException;
import java.util.Properties;

import static util.Constants.*;

public class PropertiesUtil {
    public static final Properties PROPERTIES = new Properties();

    static {
        load();
    }
    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    private static void load() {
        try (var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
