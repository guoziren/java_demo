package com.ustc.service.impl;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

import com.ustc.util.Computor;
import com.ustc.util.FileUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {FileUtil.class, Computor.class})
public class MyServiceImplTest {
    private static final String ERROR_MSG = "TEST";
    private MyServiceImpl myService;

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(FileUtil.class);
        myService = new MyServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
    }
    /**************** mock 静态公有方法 start ********************/
    /**
     * 验证调用次数
     */
    @Test
    public void testStaticPublicMethod1() throws Exception {
        myService.testStaticPublicMethod1();
        PowerMockito.verifyStatic(FileUtil.class, Mockito.times(1));
        FileUtil.read(Mockito.anyString());
    }

    /**
     * 有返回值，验证返回值是否相等
     */
    @Test
    public void testStaticPublicMethod2() throws Exception {
        String result = "abc";
        Mockito.when(FileUtil.read(Mockito.anyString())).thenReturn(result);
        Assert.assertEquals(result, myService.testStaticPublicMethod2());
        PowerMockito.verifyStatic(FileUtil.class, Mockito.times(1));
        FileUtil.read(Mockito.anyString());
    }

    /**
     * 无返回值，验证(行为)调用次数
     */
    @Test
    public void testStaticPublicMethod3() throws Exception {
        myService.testStaticPublicMethod3();
        PowerMockito.verifyStatic(FileUtil.class, Mockito.times(1));
        FileUtil.read2(Mockito.anyString());
    }
    /**************** mock 静态公有方法 end ********************/

    /**************** mock 静态私有方法 start ********************/
    @Test
    public void testStatiPrivateMethod1() throws Exception {
        PowerMockito.spy(FileUtil.class);
        String result = "abc";
        PowerMockito.doReturn(result).when(FileUtil.class, "read3Private", "");
        myService.testStatiPrivateMethod1();
        PowerMockito.verifyPrivate(FileUtil.class, Mockito.times(1)).invoke("read3Private", "");
    }

    @Test
    public void testStatiPrivateMethod2() throws Exception {
        PowerMockito.spy(FileUtil.class);
        PowerMockito.doNothing().when(FileUtil.class, "read4Private", "");
        myService.testStatiPrivateMethod2();
        PowerMockito.verifyPrivate(FileUtil.class, Mockito.times(1)).invoke("read4Private", "");
    }

    /**************** mock 静态私有方法 end ********************/

    /**************** mock 私有方法 start ********************/
    @Test
    public void testPrivateMethod1() throws Exception {
        Computor spy = PowerMockito.spy(new Computor());
        // 注，mock私有方法的返回值要用下面这种写法，即doReturn...when...  ， 而非 when...then return，
        // 是因为和spy一起用? 不用spy就还是用 when...then return
        PowerMockito.doReturn(5).when(spy, "realAdd", anyInt(), anyInt());
        // Only void methods can doNothing()!
        myService.testPrivateMethod1(spy);
        // verifyPrivate 既适用于对象私有方法，也适用于类私有方法
        PowerMockito.verifyPrivate(spy, Mockito.times(1)).invoke("realAdd", anyInt(), anyInt());
    }

    /**************** mock 私有方法 end ********************/

    /**************** mock抛出异常 start ********************/
    /**
     * 公有方法抛出异常
     */
    @Test
    public void testPublicThrowException() {
        Computor computor = Mockito.mock(Computor.class);
        Mockito.when(computor.add(anyInt(), anyInt())).thenThrow(new RuntimeException(ERROR_MSG));
        try {
            computor.add(1,2);
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().equals(ERROR_MSG));
        }
    }

    /**
     * 私有方法抛出异常
     */
    @Test
    public void testPrivateThrowException() throws Exception {
        Computor computor = PowerMockito.spy(new Computor());
        PowerMockito.doThrow(new RuntimeException(ERROR_MSG)).when(computor, "realAdd",anyInt(), anyInt());
        try {
            computor.add(1,2);
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().equals(ERROR_MSG));
        }
    }

    /**
     * 静态公有方法抛出异常
     */
    @Test
    public void testStaticPublicThrowException() {
        PowerMockito.when(FileUtil.read(anyString())).thenThrow(new RuntimeException(ERROR_MSG));
        try {
            FileUtil.read("");
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().equals(ERROR_MSG));
        }
    }

    /**
     * 静态私有方法抛出异常
     */
    @Test
    public void testStaticPrivateThrowException() throws Exception {
        PowerMockito.doThrow(new RuntimeException(ERROR_MSG)).when(FileUtil.class, "read3Private", anyString());
        try {
            FileUtil.read3("");
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().equals(ERROR_MSG));
        }
    }
    /**************** mock抛出异常 end ********************/

    /**************** mock final start ********************/
    // 注: 给FileUtil的类和方法上都加上final修饰，上面测试代码不用修改也是通过的
    /**************** mock final end ********************/

    /**************** mock 异步转同步 start ********************/

    /**************** mock 异步转同步 end ********************/

    /**************** mock 替换静态方法 start ********************/

    /**************** mock 替换静态方法 end ********************/

    /**************** mock new start ********************/
    @Test
    public void testNew() throws Exception {
        Computor computor = Mockito.mock(Computor.class);
        Mockito.when(computor.add(anyInt(), anyInt())).thenReturn(5);
        PowerMockito.whenNew(Computor.class).withNoArguments().thenReturn(computor);
        String result = new FileUtil().testNew();
        Assert.assertEquals("5", result);
    }
    /**************** mock new end ********************/


    /**************** mock 参数捕获  ********************/
    /**************** mock spring项目  ********************/
    /**************** jacoco覆盖率项目搭建 ********************/
}