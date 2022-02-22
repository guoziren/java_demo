package com.ustc.demo.inject.config;

import com.ustc.demo.inject.bean.Fruit;
import com.ustc.demo.inject.FruitService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Date: 2022/2/22
 */
@Configuration
public class MyConfiguration {
    @Bean
    public FruitService getFruitService(ObjectProvider<Fruit> object) {
        return new FruitService(object);
    }


}
