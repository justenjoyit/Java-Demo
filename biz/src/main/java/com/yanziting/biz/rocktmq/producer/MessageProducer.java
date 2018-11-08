package com.yanziting.biz.rocktmq.producer;

import com.yanziting.biz.rocktmq.task.OrderMessageTask;
import com.yanziting.biz.rocktmq.task.ShipMessageTask;

import java.io.IOException;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-08-08-01
 **/
@Slf4j
@Component
public class MessageProducer {

    @Resource
    private OrderProducer orderProducer;
    @Resource
    private ShipProducer shipProducer;
    public void sendOrderMessage(Object data) throws InterruptedException, IOException, RemotingException, MQClientException, MQBrokerException {
        OrderMessageTask task = new OrderMessageTask(new OrderProducer(),data);
        task.send();
    }

    public void sendShipMessage(String data) throws InterruptedException, IOException, RemotingException, MQClientException, MQBrokerException {
        ShipMessageTask task = new ShipMessageTask(shipProducer,data);
        task.send();
    }
}
