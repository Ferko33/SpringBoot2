package com.ferko.boot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("断言测试")
@SpringBootTest
public class Junit5AssertionsTest {

    /**
     * assertEquals	判断两个对象或两个原始类型是否相等
     * assertNotEquals	判断两个对象或两个原始类型是否不相等
     * assertSame	判断两个对象引用是否指向同一个对象
     * assertNotSame	判断两个对象引用是否指向不同的对象
     * assertTrue	判断给定的布尔值是否为 true
     * assertFalse	判断给定的布尔值是否为 false
     * assertNull	判断给定的对象引用是否为 null
     * assertNotNull	判断给定的对象引用是否不为 null
     */
    @DisplayName("简单断言")
    @Test
    void testSimpleAssertions() {
        int cal = cal(1, 2);
        //前面的参数是期望返回的值，后面是真实的值，可以自定义错误提示信息
        assertEquals(3,cal,"业务逻辑计算失败");

        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2,"二者不是同一个对象");
    }

    //假设业务方法
    int cal(int i, int j) {
        return i + j;
    }

    //数组断言
    @Test
    @DisplayName("array assertion")
    public void array() {
        assertArrayEquals(new int[]{1, 2}, new int[] {1, 2});
    }

    //组合断言
    @Test
    @DisplayName("assert all")
    public void all() {
        /*
            所有断言都成功， 才可以成功
         */
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0)
        );
    }

    //异常断言
    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {

        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0));

    }

    //快速失败
    @Test
    @DisplayName("fail")
    public void shouldFail() {
        fail("This should fail");
    }

}
