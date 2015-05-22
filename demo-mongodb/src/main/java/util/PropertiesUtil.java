package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by trieudoan on 5/22/2015.
 */
public class PropertiesUtil {
    private PropertiesUtil(){}

    public static Properties readProperties(String propertiesFile) {
        InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesFile);

        Properties prop = new Properties();
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;

    }
}
