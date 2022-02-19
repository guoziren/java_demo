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
    public void testStaticPublicMethod1() {
        String path = "";
        FileUtil.read(path);
    }

    @Override
    public String testStaticPublicMethod2() {
        String path = "";
        return FileUtil.read(path);
    }

    @Override
    public void testStaticPublicMethod3() {
        String path = "";
        FileUtil.read2(path);
    }

    @Override
    public String testStatiPrivateMethod1() {
        String path = "";
        return FileUtil.read3(path);
    }

    @Override
    public void testStatiPrivateMethod2() {
        String path = "";
        FileUtil.read4(path);
    }

    @Override
    public int testPrivateMethod1(Computor computor) {
        return computor.add(1,2);
    }
}
