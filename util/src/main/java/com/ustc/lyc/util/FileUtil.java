package com.ustc.lyc.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class FileUtil {

    public static Set<String> readFileToSet(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }

        Set<String> set = new HashSet<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String s = null;
            while ((s = reader.readLine()) != null) {
                set.add(s);
            }
        } catch (IOException e) {
            log.error("", e);
        }
        return set;
    }
}
