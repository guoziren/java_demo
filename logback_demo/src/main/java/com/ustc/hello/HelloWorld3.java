package com.ustc.hello;

import java.util.logging.Logger;

public class HelloWorld3 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(HelloWorld3.class.getName());
        logger.info("test");
        logger.config("test");
        logger.warning("test");
        logger.severe("test");
    }
}
