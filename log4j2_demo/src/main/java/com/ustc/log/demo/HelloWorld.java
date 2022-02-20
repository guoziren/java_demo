package com.ustc.log.demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(HelloWorld.class.getName());
        logger.debug("Hello world.");
        logger.trace("Hello world.");
        logger.error("Hello world.");

    }
}
