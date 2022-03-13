package com.ustc.spring.aop.service;

import com.ustc.spring.aop.annotaion.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Date: 2022/2/22
 */

@Service
@Slf4j
public class TestService {
    @LogAnnotation
    public void test() {
        log.info("test");
    }
}
