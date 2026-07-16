package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
        private static final Properties props = new Properties();

        static {
            try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
                props.load(in);
            } catch (IOException e) {
                throw new RuntimeException("could not load config.properties", e);
            }
        }

        public static String getProperty(String key){
            return props.getProperty(key);
        }
}
