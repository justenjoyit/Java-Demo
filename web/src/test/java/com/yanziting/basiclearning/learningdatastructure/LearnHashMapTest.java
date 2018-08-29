package com.yanziting.basiclearning.learningdatastructure;

import com.yanziting.web.WebApplication;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : Ziting.Yan
 * @since : 2018-08-29-21-31
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class LearnHashMapTest {

    @Resource
    private LearnHashMap learnHashMap;

    @Test
    public void learnPutIfAbsent(){
        learnHashMap.learnPutIfAbsent();
    }
}
