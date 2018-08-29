package com.yanziting.basiclearning.learningdatastructure;

import com.google.common.collect.Maps;

import java.util.HashMap;

import org.springframework.stereotype.Component;

/**
 * @author : Ziting.Yan
 * @since : 2018-08-29-17-17
 **/
@Component("learnHashMap")
public class LearnHashMap {


    public void learnPutIfAbsent() {
        System.out.println("========= putIfAbsent 当没有该值时会添加，否则会一直取旧值=========");
        HashMap<String, String> map = Maps.newHashMap();
        String result = map.putIfAbsent("key1", "value1");
        if (null == result) {
            System.out.println("第一次putIfAbsent:null");
            result = map.put("key1", "value1");
            System.out.println("第一次putIfAbsent为null后:" + result);
        } else {
            System.out.println("第一次putIfAbsent:" + result);
        }

        result = map.putIfAbsent("key1", "value1");
        System.out.println("第二次putIfAbsent:" + result);

        result = map.putIfAbsent("key1", "value3");
        System.out.println("第三次putIfAbsent:" + result);

    }
}
