package com.ironman.ma.badelog.factory;

import com.ironman.ma.badelog.BadeLog;
import com.ironman.ma.badelog.commons.BadeLogPropertyManager;
import com.ironman.ma.badelog.level.LogLevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.ironman.ma.badelog.commons.StringConstants.*;

/**
 * Created by 127.0.0.1.ma on 09/09/17.
 */
public final class BadeLoggerFactory {
    private static Map<LogLevel, BufferedWriter> logLevelRouter;
    private static BufferedWriter bufferedWriter;
    private static SimpleDateFormat simpleDateFormat;
//    new SimpleDateFormat("MM-dd-yyyy")

    static {
        /*
            initialise WriteBuffers
         */
        init();
        /*
        have a connection Pool object, use get connection and write
        DataSourceComboPool db
         */
    }

    public static BufferedWriter getBufferedWriter(LogLevel logLevel) {
        return logLevelRouter.get(logLevel);
    }

    public static String getDateInFormat() {
        return simpleDateFormat.format(new Date());
    }

//    public static BufferedWriter getBufferedWriter() {
//        return bufferedWriter;
//    }

    public static Connection getDatasourceConnection() {
        /*
            return data connection
         */
        return null;
    }

    private static void init() {
        /*
            Read configs, create files and hand it over to write buffer
         */
        logLevelRouter = new HashMap<LogLevel, BufferedWriter>();
        String dateFormat = BadeLogPropertyManager.getlogProps(TS_FORMAT_PROPERTYKEY);
        simpleDateFormat = new SimpleDateFormat(dateFormat);
        String[] logLevels = BadeLogPropertyManager.getlogProps(LOG_LEVEL_PROPERTYKEY).split(",");
        String logFileLocation = BadeLogPropertyManager.getlogProps(FILE_LOCATION_PROPERTYKEY);
        File logFile = new File(logFileLocation);
        try {
            logFile.getParentFile().mkdirs();
            logFile.createNewFile();
            bufferedWriter = new BufferedWriter(new FileWriter(logFile, true), WRITE_BUFFER_SIZE);
            for (String s : logLevels) {
                LogLevel logLevel = LogLevel.valueOf(s);
                logLevelRouter.put(logLevel, bufferedWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static BadeLog getLogger(Class namespace) {
        return new BadeLog(namespace);
    }

}
