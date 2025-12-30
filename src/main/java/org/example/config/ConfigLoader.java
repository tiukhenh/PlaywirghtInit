package org.example.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties;

    static {
        try (InputStream is =
                     ConfigLoader.class
                             .getClassLoader()
                             .getResourceAsStream("loaddata.properties")) {

            properties = new Properties();
            properties.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Cannot load config.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}
