package com.ustc.demo.inject.bean;

import lombok.Data;
import org.springframework.core.Ordered;

/**
 * @Description:
 * @Date: 2022/2/22
 */
@Data
public abstract class Fruit implements Ordered {
    private String name;

}
