package com.ustc.service.impl;

import com.ustc.service.MyService;
import com.ustc.util.Computor;
import com.ustc.util.FileUtil;

/**
 * @Description:
 * @Date: 2022/2/19
 */
public class MyServiceImpl implements MyService {

    @Override
    public void method1() {
        String path = "";
        FileUtil.read(path);
    }

    @Override
    public String method2() {
        String path = "";
        return FileUtil.read(path);
    }

    @Override
    public void method3() {
        String path = "";
        FileUtil.read2(path);
    }

    @Override
    public String method4() {
        String path = "";
        return FileUtil.read3(path);
    }

    @Override
    public void method5() {
        String path = "";
        FileUtil.read4(path);
    }

    @Override
    public int method6(Computor computor) {
        return computor.add(1,2);
    }
}
