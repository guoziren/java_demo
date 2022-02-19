package com.ustc.service.impl;

import com.ustc.service.PowermockPractiseService;
import com.ustc.util.AsyncExecutor;
import com.ustc.util.Computor;
import com.ustc.util.FileUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: Powermock 练习
 * @Date: 2022/2/19
 */
@Slf4j
public class PowermockPractiseServiceImpl implements PowermockPractiseService {

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

    @Override
    public void testAsync() {
        AsyncExecutor.getInstance().execute(() -> {
            log.info("testAsync");
        });
    }
}
