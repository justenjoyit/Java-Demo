package com.yanziting.biz.rocktmq.listener;

import com.yanziting.biz.rocktmq.message.OrderMessage;
import com.yanziting.biz.rocktmq.service.OrderServiceImpl;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-07-12-16
 **/
@Component
@Slf4j
public class OrderBackMessageListener implements MessageListenerConcurrently {

    @Resource
    private OrderServiceImpl orderServiceImpl;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        ConsumeConcurrentlyStatus status = ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        log.info("[{}] received messages", context.getMessageQueue().getTopic());
        for (MessageExt msg : msgs) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(msg.getBody());
                ObjectInputStream ois = new ObjectInputStream(bis);
                Object obj = ois.readObject();
                log.info("received order message body {}", obj);
                OrderMessage orderMessage = (OrderMessage)obj;
                orderServiceImpl.handleOrder(orderMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }



}
