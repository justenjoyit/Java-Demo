package com.yanziting.biz.rocktmq.listener;

import com.yanziting.biz.rocktmq.message.ShipMessage;
import com.yanziting.biz.rocktmq.service.ShipServiceImpl;

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
 * @since : 2018-11-08-15-34
 **/
@Slf4j
@Component
public class ShipBackMessageListener implements MessageListenerConcurrently {

    @Resource
    private ShipServiceImpl shipServiceImpl;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        ConsumeConcurrentlyStatus status = ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        log.info("[{}] received messages", context.getMessageQueue().getTopic());
        for (MessageExt msg : msgs) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(msg.getBody());
                ObjectInputStream ois = null;
                ois = new ObjectInputStream(bis);
                Object obj = ois.readObject();
                log.info("received ship message body {}", obj);
                ShipMessage shipMessage = (ShipMessage)obj;
                shipServiceImpl.handleShip(shipMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return status;
    }
}
