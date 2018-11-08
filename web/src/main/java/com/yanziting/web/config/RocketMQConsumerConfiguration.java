package com.yanziting.web.config;

import com.yanziting.biz.rocktmq.consumer.OrderConsumer;
import com.yanziting.biz.rocktmq.consumer.ShipConsumer;
import com.yanziting.biz.rocktmq.listener.OrderBackMessageListener;
import com.yanziting.biz.rocktmq.listener.ShipBackMessageListener;

import java.util.List;

import javax.annotation.Resource;

import lombok.Data;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-08-12-04
 **/
@Configuration
@ConfigurationProperties(prefix = "yanzt.rocketmq")
@Data
public class RocketMQConsumerConfiguration {
    private String namesrvAddr;
    private List<String> topics;
    private List<String> producerGroups;
    private List<String> consumerGroups;

    @Resource
    private OrderBackMessageListener orderBackMessageListener;
    @Resource
    private ShipBackMessageListener shipBackMessageListener;

    @Bean(initMethod = "doStart",destroyMethod = "doShutdown")
    public OrderConsumer orderConsumer() throws MQClientException {
        final OrderConsumer orderConsumer = new OrderConsumer();
        orderConsumer.setNamesrvAddr(namesrvAddr);
        orderConsumer.setTopic(topics.get(0));
        orderConsumer.setConsumerGroup(consumerGroups.get(0));
        orderConsumer.setOrderBackMessageListener(orderBackMessageListener);
        return orderConsumer;
    }

    @Bean(initMethod = "doStart", destroyMethod = "doShutdown")
    public ShipConsumer shipConsumer() throws MQClientException {
        ShipConsumer shipConsumer = new ShipConsumer();
        shipConsumer.setNamesrvAddr(namesrvAddr);
        shipConsumer.setTopic(topics.get(1));
        shipConsumer.setConsumerGroup(consumerGroups.get(1));
        shipConsumer.registerMessageListener(shipBackMessageListener);
        return shipConsumer;
    }
}
