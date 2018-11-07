package com.yanziting.biz.rocktmq.consumer;

import com.yanziting.biz.rocktmq.listener.OrderBackMessageListener;

import lombok.Setter;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-02-07-32
 **/
@Setter
public class OrderConsumer extends DefaultMQPushConsumer {

    private String topic;
    private OrderBackMessageListener orderBackMessageListener;

    public void doStart() throws MQClientException {
        this.registerMessageListener(orderBackMessageListener);
        this.start();
    }

    public void doShutdown() {
        this.shutdown();
    }

    public void setTopic(String topic) throws MQClientException {
        this.topic = topic;
        this.subscribe(this.topic, "*");
    }

    public void registerMsgListener(OrderBackMessageListener orderBackMessageListener) {
        this.orderBackMessageListener = orderBackMessageListener;
    }
}
