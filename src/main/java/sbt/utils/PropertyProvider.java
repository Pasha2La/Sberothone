package sbt.utils;

import jdk.nashorn.internal.objects.annotations.Property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by durachenko-sv on 26.01.2019.
 */

public class PropertyProvider {
    private static Properties property = new Properties();

    static {
        try {
            FileInputStream fis = null;
            fis = new FileInputStream("src/main/resources/application.properties");
            property.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return property.getProperty(key);
    }

}

