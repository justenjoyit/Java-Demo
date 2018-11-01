package com.yanziting.rocketmq;

//import com.yanziting.biz.rocktmq.OrderConsumer;
import com.yanziting.biz.rocktmq.OrderConsumer;
import com.yanziting.biz.rocktmq.OrderProducer;
import com.yanziting.biz.rocktmq.TestProducer;
import com.yanziting.biz.rocktmq.TestProducerImpl;
import com.yanziting.web.WebApplication;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : Ziting.Yan
 * @since : 2018-10-31-21-02
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class ProducerTest {
    @Resource
    private TestProducerImpl testProducer;
    @Resource
    private OrderConsumer orderConsumer;

    @Test
    public void test() throws Exception {
        testProducer.send();
    }

    @Test
    public void test2(){

    }
}
