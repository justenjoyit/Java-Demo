package com.yanziting.biz.rocktmq.task;

import com.yanziting.biz.rocktmq.producer.OrderProducer;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-08-08-07
 **/
@Slf4j
public class OrderMessageTask {
    private OrderProducer orderProducer;
    private Object data;


    public OrderMessageTask(OrderProducer orderProducer,Object data){
        this.orderProducer = orderProducer;
        this.data = data;
    }

    public void send() throws InterruptedException, IOException, RemotingException, MQClientException, MQBrokerException {
        orderProducer.sendMessage(data);
    }
}
