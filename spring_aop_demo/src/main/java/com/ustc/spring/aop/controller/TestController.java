package com.ustc.spring.aop.controller;

import com.ustc.spring.aop.service.TestService;
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
    TestService testService;

    @RequestMapping("/1")
    public void test() {
        testService.test();
    }

}
