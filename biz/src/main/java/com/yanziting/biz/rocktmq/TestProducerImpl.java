package com.yanziting.biz.rocktmq;

import javax.annotation.Resource;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Ziting.Yan
 * @since : 2018-10-31-20-58
 **/
@Service
public class TestProducerImpl {

    @Resource
    private OrderProducer orderProducer;
    @Autowired
    private OrderConsumer orderConsumer;
//    @Resource
//    private DefaultMQPushConsumer pushConsumer;

    public void send() throws Exception {
        for (int i = 0; i < 10; ++i) {
            orderProducer.sendMessage("order producer send message: " + i);
        }
    }

    public void consume(){
    }
}
