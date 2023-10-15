package envReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class EnvReader
{

    public static Properties properties;

    public static Properties getProperties() throws IOException
    {
        File propertiesFile = new File("src/main/resources/env.properties");

        FileInputStream fileInputStream = new FileInputStream(propertiesFile);

        properties = new Properties();

        properties.load(fileInputStream);

        fileInputStream.close();

        return properties;
    }

    public static String getProperty(String key) throws IOException
    {
        return getProperties().getProperty(key);
    }
}
