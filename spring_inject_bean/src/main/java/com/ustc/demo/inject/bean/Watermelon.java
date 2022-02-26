package com.ustc.demo.inject.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Slf4j
public class Watermelon extends Fruit{
    @Override
    public int getOrder() {
        return 0;
    }

    public Watermelon() {
        super();
        log.info("Watermelon 构造");
    }

    @Override
    public String getName() {
        return "Watermelon";
    }
}
