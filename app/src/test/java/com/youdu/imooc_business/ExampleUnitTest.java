package com.youdu.imooc_business;


import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        Class clazz = ExampleUnitTest.class;
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println(classLoader.toString());
    }


}