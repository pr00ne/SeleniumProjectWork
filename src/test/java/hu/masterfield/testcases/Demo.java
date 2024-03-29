package hu.masterfield.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * Kipróbáljuk, működnek-e az osztályok. :)
 */

public class Demo extends BaseTest {

    protected static Logger logger = LogManager.getLogger(Demo.class);

    @Test
    public void testDemo() throws InterruptedException {
        Thread.sleep(1000);
        logger.info("This is a demo test");
    }

}
