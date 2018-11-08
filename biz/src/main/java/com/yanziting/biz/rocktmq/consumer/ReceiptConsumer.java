package com.yanziting.biz.rocktmq.consumer;

import com.yanziting.biz.rocktmq.listener.ReceiptBackMessageListener;

import lombok.Setter;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-08-19-19
 **/
@Setter
public class ReceiptConsumer extends DefaultMQPushConsumer {

    private String topic;
    private ReceiptBackMessageListener receiptBackMessageListener;

    public void setTopic(String topic) throws MQClientException {
        this.topic = topic;
        this.subscribe(this.topic, "*");
    }

    public void doStart() throws MQClientException {
        this.start();
    }

    public void doShutdown() {
        this.shutdown();
    }
}
