package com.ustc.util;

/**
 * @Description:
 * @Date: 2022/2/19
 */
public final class FileUtil {

    public String testNew() {
        Computor computor = new Computor();
        return String.valueOf(computor.add(1,2));
    }

    // 公有方法有返回值
    public final static String read(String path) {
        throw new UnsupportedOperationException("暂不支持");
    }
    // 公有方法，无返回值
    public final static void read2(String path) {
        throw new UnsupportedOperationException("暂不支持");
    }

    public final static String read3(String path) {
        // here, do something
        return read3Private(path);
    }

    public final static void read4(String path) {
        // here, do something
         read4Private(path);
    }

    private final static String read3Private(String path) {
        throw new UnsupportedOperationException("暂不支持");
    }

    private final static void read4Private(String path) {
        throw new UnsupportedOperationException("暂不支持");
    }
}
