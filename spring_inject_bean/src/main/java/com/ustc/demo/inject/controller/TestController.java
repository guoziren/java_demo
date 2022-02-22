package com.ustc.demo.inject.controller;

import com.ustc.demo.inject.bean.Fruit;
import com.ustc.demo.inject.FruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
}
