package com.ironman.ma.badelog.write;

import com.ironman.ma.badelog.level.LogLevel;

/**
 * Created by 127.0.0.1.ma on 09/09/17.
 */
public interface AbstractPersistInterface {
    void write(String s, LogLevel logLevel);
}
