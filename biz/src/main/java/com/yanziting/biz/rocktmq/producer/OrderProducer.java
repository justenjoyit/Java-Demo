package com.yanziting.biz.rocktmq.producer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import lombok.Setter;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-02-07-04
 **/
@Setter
public class OrderProducer extends DefaultMQProducer {

    private final int BYTE_SIZE = 10240;
    private String topic;

    public void doStart() throws MQClientException {
        this.start();
    }

    public void doShutdown() {
        this.shutdown();
    }

    public void sendMessage(String data) throws InterruptedException, RemotingException, MQClientException, MQBrokerException, IOException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream(BYTE_SIZE);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArray);
        objectOutputStream.writeObject(data);
        objectOutputStream.flush();
        byte[] byteData =  byteArray.toByteArray();
        Message message = new Message(topic, byteData);
        this.send(message);
    }
}
