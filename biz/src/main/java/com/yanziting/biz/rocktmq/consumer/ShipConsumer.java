package com.yanziting.biz.rocktmq.consumer;

import com.yanziting.biz.rocktmq.listener.ShipBackMessageListener;

import lombok.Setter;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-08-15-37
 **/
@Setter
public class ShipConsumer extends DefaultMQPushConsumer {
    private String topic;
    private ShipBackMessageListener shipBackMessageListener;

    public void doStart() throws MQClientException {
        this.start();
    }

    public void doShutdown(){
        this.shutdown();
    }

    public void setTopic(String topic) throws MQClientException {
        this.topic = topic;
        this.subscribe(this.topic,"*");
    }
}
