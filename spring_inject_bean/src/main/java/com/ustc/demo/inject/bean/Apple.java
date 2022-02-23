package com.ustc.demo.inject.bean;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date: 2022/2/22
 */
@Component("apple")
@Slf4j
public class Apple extends Fruit implements InitializingBean {

    public Apple() {
        super();
        log.info("Apple 构造函数...");
    }

    @Override
    public String getName() {
        return "Apple";
    }

    @Override
    public int getOrder() {
        return 1;
    }



    @PostConstruct
    public void testPostConstruct () {
        log.info("Apple PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Apple afterPropertiesSet");
    }
}
