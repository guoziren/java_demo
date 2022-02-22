package com.ustc.demo.inject.bean;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date: 2022/2/22
 */
@Component("orange")
public class Orange extends Fruit {

    @Override
    public String getName() {
        return "Orange";
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
