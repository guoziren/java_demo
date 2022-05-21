package com.ustc.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Description: VolatileDemo
 * @Date: 2022/4/9
 */
@Slf4j
public class VolatileDemo {

    public static boolean a = true;

    public static void main(String[] args) {
        new Thread(() -> {
            log.info("a = {}", a);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = false;
        }).start();
        while (true) {

            if (!a) {
                log.info("false");
            }
        }
    }


    public static void a() {
        while (true) {
            System.out.println();
        }
    }

}
