package com.ustc.util;

/**
 * @Description:
 * @Date: 2022/2/19
 */
public class FileUtil {
    // 公有方法有返回值
    public static String read(String path) {
        throw new UnsupportedOperationException("暂不支持");
    }
    // 公有方法，无返回值
    public static void read2(String path) {
        throw new UnsupportedOperationException("暂不支持");
    }

    public static String read3(String path) {
        // here, do something
        return read3Private(path);
    }

    public static void read4(String path) {
        // here, do something
         read4Private(path);
    }

    private static String read3Private(String path) {
        throw new UnsupportedOperationException("暂不支持");
    }

    private static void read4Private(String path) {
        throw new UnsupportedOperationException("暂不支持");
    }
}
