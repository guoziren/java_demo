package com.ustc.demo.inject.bean;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date: 2022/2/22
 */
@Component("apple")
public class Apple extends Fruit {

    @Override
    public String getName() {
        return "Apple";
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
