package com.ustc.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Optional;

/**
 * @Date: 2022/5/7
 */
public class GuavaCache {

    public static void main(String[] args) {
        CacheLoader<String, Optional<String>> loader = new CacheLoader<String, Optional<String>>() {
            public Optional<String> load(String key) throws Exception {
                Thread.sleep(1000); //休眠1s，模拟加载数据
                System.out.println(key + " is loaded from a cacheLoader!");
                if (true) {
                    return Optional.empty();
                }
                return Optional.of(key + "'s value");
            }
        };

        LoadingCache<String, Optional<String>> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build(loader);//在构建时指定自动加载器

    }
}
