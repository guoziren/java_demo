package com.ustc.lyc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: lycguo
 * @Description:
 * @Date: 2022/1/27
 */
@Slf4j
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

    /**
     * futureTask 执行超时， 状态为NEW
     * futureTask 执行被抛出异常， 状态为EXCEPTIONAL, isDone返回true， isCancelled返回fasle
     * CANCELLED状态比异常高，
     */
    public void testCreateThread3() {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.info("futureTask  call");
                Thread.sleep(3000);
                throw new RuntimeException("test");
//                return 5;
            }
        });

        Thread thread = new Thread(futureTask);
        thread.start();
        boolean isCancelled = futureTask.isCancelled();
        boolean isDone = futureTask.isDone();
        log.info("cancelled = {}", isCancelled);
        log.info("isDone = {}", isDone);
        try {
            log.info("futureTask.get() call");
            Integer integer = futureTask.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("", e);
        } catch (ExecutionException e) {
            log.error("", e);
        } catch (TimeoutException e) {
            log.error("", e);
        }

        isCancelled = futureTask.isCancelled();
        isDone = futureTask.isDone();
        log.info("cancelled = {}", isCancelled);
        log.info("isDone = {}", isDone);
    }
}
