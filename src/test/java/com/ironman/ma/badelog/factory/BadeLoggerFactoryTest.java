package com.ironman.ma.badelog.factory;

import junit.framework.TestCase;

/**
 * Created by 127.0.0.1.ma on 09/09/17.
 */
public class BadeLoggerFactoryTest extends TestCase {
    public void testGetLogger() throws Exception {
        /*
            remove log file
         */

        BadeLoggerFactory.getLogger(BadeLoggerFactoryTest.class);
        /*
            check if log file was created here and assert
         */
    }
}