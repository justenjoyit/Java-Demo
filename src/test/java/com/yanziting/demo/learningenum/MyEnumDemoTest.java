package com.yanziting.demo.learningenum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : Ziting.Yan
 * @since : 2018-08-07-15-20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyEnumDemoTest {

    @Autowired
    private MyEnumDemo myEnumDemo;

    /**
     * 测试枚举类
     */
    @Test
    public void getWeek() {
        myEnumDemo.getWeek();
    }

    /**
     * 测试switch
     */
    @Test
    public void printDistinctWeek() {
        myEnumDemo.printDistinctWeek(Week.SUNDAY);
    }
}
