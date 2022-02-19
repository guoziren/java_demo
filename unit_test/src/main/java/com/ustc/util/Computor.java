package com.ustc.util;

/**
 * @Description:
 * @Date: 2022/2/19
 */
public class Computor {
    public static int staticAdd(int x, int y) {
        return realStaticAdd(x, y);
    }

    private static int realStaticAdd(int x, int y) {
        throw new UnsupportedOperationException("暂不支持");
    }

    public int add(int x, int y) {
        return realAdd(x, y);
    }

    private int realAdd(int x, int y) {
        throw new UnsupportedOperationException("暂不支持");
    }
}
