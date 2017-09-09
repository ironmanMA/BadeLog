package com.ironman.ma.badelog.level;

/**
 * Created by 127.0.0.1.ma on 09/09/17.
 */
public enum LogLevel {
    ERROR("ERROR"),
    INFO("INFO"),
    DEBUG("DEBUG"),
    WARN("WARN"),
    FATAL("FATAL");
    private String value;

    private LogLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
