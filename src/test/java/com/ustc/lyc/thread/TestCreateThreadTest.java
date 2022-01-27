package com.ustc.lyc.thread;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCreateThreadTest {
    private  TestCreateThread testCreateThread;
    @BeforeEach
    void setUp() {
        testCreateThread = new TestCreateThread();
    }

    @Test
    void testCreateThread3() {
        testCreateThread.testCreateThread3();
    }
}