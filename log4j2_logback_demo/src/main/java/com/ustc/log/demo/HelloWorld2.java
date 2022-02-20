package com.ustc.log.demo;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld2 {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloWorld2.class.getName());
        logger.error("Hello world.");

        LogManager.getLogger(HelloWorld2.class.getName()).error("Hello log4j2");
    }
}
