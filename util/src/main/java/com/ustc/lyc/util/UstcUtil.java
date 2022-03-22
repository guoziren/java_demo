package com.ustc.lyc.util;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UstcUtil {
    public static void main(String[] args) {
            tongji();
    }
    public static void tongji() {
        String f1 = "D:\\2022-spring-graduate-name-list.txt";
        String f2 = "D:\\ustc-sse-2019-all-name-list.txt";

        Set<String> xuewei = FileUtil.readFileToSet(f1);
        Set<String> all = FileUtil.readFileToSet(f2);

        int count = 0;
        for (String s : xuewei) {
            if (!all.contains(s)) {
                System.out.println(s);
            } else {
                count++;
            }
        }
        System.out.println(count);
    }
}
