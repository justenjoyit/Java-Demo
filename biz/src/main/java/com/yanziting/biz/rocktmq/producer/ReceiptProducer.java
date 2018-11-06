package com.yanziting.biz.rocktmq.producer;

import lombok.Setter;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-06-07-35
 **/
@Setter
public class ReceiptProducer extends DefaultMQProducer {

    private String topic;

    public void doStart() throws MQClientException {
        this.start();
    }

    public void doShutdown() {
        this.shutdown();
    }

    public void sendMessage(String data) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        Message message = new Message(topic, data.getBytes());
        this.send(message);
    }
}
