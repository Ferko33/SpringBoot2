package com.ferko.boot;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

@DisplayName("Junit5功能测试类")
public class Junit5Test {

    //@DisplayName 为测试类或者测试方法设置展示名称
    @DisplayName("测试 @DisplayName 注解")
    @Test
    void testDisplayName(){
        System.out.println(1);
    }

    //@Disabled 表示测试类或测试方法不执行，类似于JUnit4中的@Ignore
    @Disabled
    @DisplayName("测试方法2")
    @Test
    void test2(){
        System.out.println(2);
    }

    // @Timeout 表示测试方法运行超过了指定时间,将会返回异常
    @Timeout(value = 500,unit= TimeUnit.MILLISECONDS)
    @Test
    void timeOutTest() throws InterruptedException {
        Thread.sleep(600);
    }

    //@RepeatedTest(5) 表示方法可重复执行5次
    @RepeatedTest(5)
    @DisplayName("重复测试")
    @Test
    void test3(){
        System.out.println(5);
    }

    //@BeforeEach 表示在每个单元测试之前执行
    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试就要开始了");
    }

    //@AfterEach 表示在每个单元测试之后执行
    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了");
    }

    //@BeforeAll 表示在所有单元测试之前执行，方法要声明为static的。
    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有的测试就要开始了");
    }

    //@AfterAll 表示在所有单元测试之后执行，方法要声明为static的。
    @AfterAll
    static void testAfterAll(){
        System.out.println("所有的测试结束了");
    }
}
