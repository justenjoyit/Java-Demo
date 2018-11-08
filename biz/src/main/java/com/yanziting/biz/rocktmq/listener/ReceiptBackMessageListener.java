package com.yanziting.biz.rocktmq.listener;

import com.yanziting.biz.rocktmq.message.ReceiptMessage;
import com.yanziting.biz.rocktmq.service.ReceiptServiceImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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
 * @since : 2018-11-08-19-09
 **/
@Component
@Slf4j
public class ReceiptBackMessageListener implements MessageListenerConcurrently {

    @Resource
    private ReceiptServiceImpl receiptServiceImpl;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        ConsumeConcurrentlyStatus status = ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        log.info("[{}] received messages", context.getMessageQueue().getTopic());
        for (MessageExt msg : msgs) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(msg.getBody());
                ObjectInputStream ois = new ObjectInputStream(bis);
                Object object = ois.readObject();
                log.info("received receipt message body {}", object);
                ReceiptMessage receiptMessage = (ReceiptMessage) object;
                receiptServiceImpl.handleReceipt(receiptMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
