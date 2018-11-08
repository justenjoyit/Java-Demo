package com.yanziting.biz.rocktmq.task;

import com.yanziting.biz.rocktmq.producer.OrderProducer;
import com.yanziting.biz.rocktmq.producer.ShipProducer;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-08-08-11
 **/
@Slf4j
public class ShipMessageTask {
    private ShipProducer shipProducer;
    private String data;


    public ShipMessageTask(ShipProducer shipProducer,String data){
        this.shipProducer = shipProducer;
        this.data = data;
    }

    public void send() throws InterruptedException, IOException, RemotingException, MQClientException, MQBrokerException {
        shipProducer.sendMessage(data);
    }
}
