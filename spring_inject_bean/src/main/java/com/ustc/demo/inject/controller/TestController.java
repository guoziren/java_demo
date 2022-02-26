package com.ustc.demo.inject.controller;

import com.ustc.demo.inject.bean.Apple;
import com.ustc.demo.inject.bean.Fruit;
import com.ustc.demo.inject.bean.Watermelon;
import com.ustc.demo.inject.service.FruitService;
import com.ustc.demo.inject.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Date: 2022/2/22
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    FruitService fruitService;

    @RequestMapping("/1")
    public void test() {
        Fruit fruit = fruitService.getFruitObjectProvider().stream().findFirst().get();
        log.info("first is {}", fruit.getName());

        fruitService.getFruitObjectProvider().orderedStream()
                .forEach(e -> log.info("{}, order = {}", e.toString(), e.getOrder()));
    }

    /**
     * prototype scope ， 每次从容器中获得的是新的对象，生成的对象不会被存到容器中
     */
    @RequestMapping("/testPrototype")
    public void testPrototype() {
        ConfigurableApplicationContext context = SpringContextUtil.getConfigurableApplicationContext();
        Apple apple1 = context.getBean(Apple.class);
        Apple apple2 = context.getBean(Apple.class);
        Watermelon watermelon1 = context.getBean(Watermelon.class);
        Watermelon watermelon2 = context.getBean(Watermelon.class);
        log.info("{} hashCode to Hex = {}", apple1, Integer.toHexString(apple1.hashCode()));
        log.info("{} hashCode to Hex = {}", apple2, Integer.toHexString(apple2.hashCode()));
        log.info("{} hashCode to Hex = {}, {}", watermelon1, Integer.toHexString(watermelon1.hashCode()), watermelon1.hashCode());
        log.info("{} hashCode to Hex = {}, {}", watermelon2, Integer.toHexString(watermelon2.hashCode()), watermelon2.hashCode());
        log.info("w1 == w2  {}", watermelon1 == watermelon2);
        log.info("a1 == a2  {}", apple1 == apple2);
    }
}
