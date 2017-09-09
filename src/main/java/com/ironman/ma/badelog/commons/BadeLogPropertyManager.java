package com.ironman.ma.badelog.commons;

import java.util.Properties;

/**
 * Created by 127.0.0.1.ma on 09/09/17.
 */
public class BadeLogPropertyManager {
    private static final String LOG_CONFIG = "badeLog.properties";
    private static Properties logProps = new Properties();
    private static boolean isInitialized = false;

    private static void init() {
        try {
            logProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream
                    (LOG_CONFIG));
            isInitialized = true;
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

    public static String getlogProps(String propertyKey) {
        if (!isInitialized) {
            init();
        }
        return logProps.getProperty(propertyKey.toLowerCase());
    }

}
