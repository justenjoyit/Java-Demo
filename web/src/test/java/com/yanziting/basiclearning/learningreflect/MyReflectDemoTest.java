package com.yanziting.basiclearning.learningreflect;

import com.yanziting.web.WebApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : Ziting.Yan
 * @since : 2018-08-07-16-41
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class MyReflectDemoTest {

    @Autowired
    private MyReflectDemo myReflectDemo;

    @Test
    public void tryReflect() {
        try {
            myReflectDemo.tryReflect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
