package com.ustc.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Date: 2022/2/19
 */
public class AsyncExecutor {
    private static AsyncExecutor asyncExecutor = new AsyncExecutor();
    private ExecutorService executorService;
    private AsyncExecutor() {
        executorService = Executors.newSingleThreadExecutor();
    }
    public static AsyncExecutor getInstance() {
        return asyncExecutor;
    }

    public void execute(Runnable runnable) {
        executorService.execute(runnable);
    }
}
