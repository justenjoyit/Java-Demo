package com.yanziting.basiclearning.learningalgorithm;

import com.yanziting.web.WebApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : Ziting.Yan
 * @since : 2018-08-15-11-57
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class DeepSearchTest {
    @Autowired
    private DeepSearch deepSearch;

    @Test
    public void mainDeepSearch(){
        deepSearch.mainDeepSearch();
    }

}
