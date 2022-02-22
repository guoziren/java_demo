package com.ustc.demo.inject.service;

import com.ustc.demo.inject.bean.Fruit;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.ObjectProvider;

/**
 * @Description:
 * @Date: 2022/2/22
 */
@Data
@AllArgsConstructor
public class FruitService {

    private ObjectProvider<Fruit> fruitObjectProvider;


}
