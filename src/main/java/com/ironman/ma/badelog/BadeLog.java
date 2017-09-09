package com.ironman.ma.badelog;

import com.ironman.ma.badelog.level.LogLevel;
import com.ironman.ma.badelog.write.PersistToFile;

import static com.ironman.ma.badelog.commons.StringConstants.DELIM;
import static com.ironman.ma.badelog.factory.BadeLoggerFactory.getDateInFormat;

/**
 * Created by 127.0.0.1.ma on 09/09/17.
 */

public class BadeLog {
    String namespace;
    PersistToFile persistToFile;

    public BadeLog(Class namespace) {
        this.namespace = namespace.getCanonicalName();
        persistToFile = new PersistToFile();
    }

    private String enrichedMessagePrefix(LogLevel logLevel) {
        return getDateInFormat() + DELIM + logLevel + DELIM + namespace + DELIM;
    }

    public void error(String message) {
        /*
            give it to write buffers
         */
        persistToFile.write(enrichedMessagePrefix(LogLevel.ERROR) + message, LogLevel.ERROR);
    }

    public void info(String message) {
        /*
            give it to write buffers
         */
        persistToFile.write(enrichedMessagePrefix(LogLevel.INFO) + message, LogLevel.INFO);
    }

    public void debug(String message) {
        /*
            give it to write buffers
         */
        persistToFile.write(enrichedMessagePrefix(LogLevel.DEBUG) + message, LogLevel.DEBUG);
    }

}
