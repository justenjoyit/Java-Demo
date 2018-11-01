package com.yanziting.web.config;

import com.yanziting.biz.rocktmq.OrderConsumer;
import com.yanziting.biz.rocktmq.OrderProducer;

import java.util.List;

import lombok.Data;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-02-07-07
 **/
@Configuration
@ConfigurationProperties(prefix = "yanzt.rocketmq")
@Data
public class RocketMQConfiguration {

    private String namesrvAddr;
    private List<String> topics;
    private List<String> producerGroups;
    private List<String> consumerGroups;

    @Bean(initMethod = "doStart",destroyMethod = "doShutdown")
    public OrderProducer orderProducer(){
        OrderProducer orderProducer = new OrderProducer();
        orderProducer.setNamesrvAddr(namesrvAddr);
        orderProducer.setTopic(topics.get(0));
        orderProducer.setProducerGroup(producerGroups.get(0));
        return orderProducer;
    }

    @Bean(initMethod = "doStart",destroyMethod = "doShutdown")
    public OrderConsumer orderConsumer() throws MQClientException {
        final OrderConsumer orderConsumer = new OrderConsumer();
        orderConsumer.setNamesrvAddr(namesrvAddr);
        orderConsumer.setTopic(topics.get(0));
        orderConsumer.setConsumerGroup(consumerGroups.get(0));
        orderConsumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                ConsumeConcurrentlyContext context) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);

                    try {
                        orderConsumer.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        return orderConsumer;
    }
}
