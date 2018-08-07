package com.yanziting.basiclearning.learningreflect;

import com.yanziting.web.WebApplication;

import java.lang.reflect.InvocationTargetException;

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
    public void tryReflect()
        throws NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchFieldException, InvocationTargetException, ClassNotFoundException {
        myReflectDemo.tryReflect();
    }
}
