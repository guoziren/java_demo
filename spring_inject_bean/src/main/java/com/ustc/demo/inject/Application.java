package com.ustc.demo.inject;

import com.ustc.demo.inject.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @Date: 2022/2/22
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        SpringContextUtil.setConfigurableApplicationContext(context);
    }
}
