package com.yanziting.biz.rocktmq.listener;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

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

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        ConsumeConcurrentlyStatus status = ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        log.info("[{}] received messages", context.getMessageQueue().getTopic());
        for (MessageExt msg : msgs) {
//            ByteArrayInputStream byteArray = new ByteArrayInputStream(msg.getBody());
//            ObjectInputStream objectInputStream = null;
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(msg.getBody());
                ObjectInputStream ois = new ObjectInputStream(bis);
                Object obj = ois.readObject();

//                objectInputStream = new ObjectInputStream(byteArray);
//                Object body  =  objectInputStream.readObject();
                log.info("received message body {}", obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }
}
