package com.ustc.lyc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: lycguo
 * @Description:
 * @Date: 2022/1/27
 */
public class TestCreateThread {
    public void testCreateThread1() {
        Thread thread = new Thread();
        thread.start();
    }

    public void testCreateThread2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("...");
            }
        });
        thread.start();
    }

    public void testCreateThread3() {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call()");
                return 5;
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();
    }
}
