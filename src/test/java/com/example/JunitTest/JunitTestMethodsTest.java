package com.example.JunitTest;

import com.example.Junit.JunitTestMethods;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class JunitTestMethodsTest {

    JunitTestMethods obj = new JunitTestMethods();

    @Test
    public void test_Junit1(){
        System.out.println("Junit Test1 Started");
        int add = obj.add(20, 10);
        assertEquals(30, add);
    }

    @Test
    public void test_Junit2(){
        System.out.println("Junit Test2 Started");
        int add = obj.add(20, 10);
        assertEquals(30, add);
    }

    @Test
    public void test_Junit3(){
        System.out.println("Junit Test3 Started");
        int add = obj.add(0, 10);
        assertEquals(10, add);
    }

    @Test
    public void test_Junit4(){
        System.out.println("Junit Test4 Started");
        int add = obj.add(20, -20);
        assertEquals(0, add);
    }
}
