package com.ustc.service;

import com.ustc.util.Computor;

public interface PowermockPractiseService {
    void testStaticPublicMethod1();
    String testStaticPublicMethod2();
    void testStaticPublicMethod3();
    String testStatiPrivateMethod1();
    void testStatiPrivateMethod2();
    int testPrivateMethod1(Computor computor);
}
