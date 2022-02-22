package com.ustc.demo.inject.bean;

import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date: 2022/2/22
 */
@Component("banana")
public class Banana extends Fruit{
    @Override
    public String getName() {
        return "banana";
    }

    @Override
    public int getOrder() {
        return 5;
    }
}
