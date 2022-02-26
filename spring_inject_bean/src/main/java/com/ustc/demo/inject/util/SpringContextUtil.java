package com.ustc.demo.inject.util;

import org.springframework.context.ConfigurableApplicationContext;

public class SpringContextUtil {
    private static ConfigurableApplicationContext configurableApplicationContext;

    public static ConfigurableApplicationContext getConfigurableApplicationContext() {
        return configurableApplicationContext;
    }

    public static void setConfigurableApplicationContext(ConfigurableApplicationContext configurableApplicationContext) {
        SpringContextUtil.configurableApplicationContext = configurableApplicationContext;
    }
}
