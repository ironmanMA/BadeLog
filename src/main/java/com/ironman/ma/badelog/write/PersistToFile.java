package com.ironman.ma.badelog.write;


import com.ironman.ma.badelog.factory.BadeLoggerFactory;
import com.ironman.ma.badelog.level.LogLevel;

import java.io.IOException;


/**
 * Created by 127.0.0.1.ma on 09/09/17.
 */
public class PersistToFile implements AbstractPersistInterface {

    public  void write(String s, LogLevel logLevel) {
        try {
            BadeLoggerFactory.getBufferedWriter(logLevel).write(s);
            BadeLoggerFactory.getBufferedWriter(logLevel).newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
