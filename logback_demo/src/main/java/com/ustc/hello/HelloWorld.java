package com.ustc.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("com.ustc.hello.HelloWorld1");
        logger.debug("Hello world.");
        logger.trace("Hello world.");
    }
}
