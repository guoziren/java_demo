package com.ustc.demo.inject.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.Ordered;

/**
 * @Description:
 * @Date: 2022/2/22
 */
@Getter
@Setter
public abstract class Fruit implements Ordered {
    private String name;

}
