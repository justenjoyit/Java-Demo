package com.yanziting.biz.rocktmq;

import lombok.Setter;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-02-07-32
 **/
public class OrderConsumer extends DefaultMQPushConsumer {
    private String topic;

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
