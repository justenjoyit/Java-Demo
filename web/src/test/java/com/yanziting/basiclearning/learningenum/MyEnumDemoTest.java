package com.yanziting.basiclearning.learningenum;

import com.yanziting.basiclearning.learningenum.MyEnumDemo.Week;
import com.yanziting.web.WebApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : Ziting.Yan
 * @since : 2018-08-07-15-20
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApplication.class)
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
        System.out.println("test");
        System.out.println("盐渍土是猪");
    }
}
