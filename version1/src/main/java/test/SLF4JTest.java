package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Chenglin Ding
 * @Date: 19.01.2021 10:56
 * @Description:
 */
public class SLF4JTest {
    private static final String TAG = "TAG";

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(SLF4JTest.class);

        logger.trace("test_trace");
        logger.debug("test_debug");
        logger.info("test_info");
        logger.warn("test_warn");
        logger.error("test_error");

    }
}
