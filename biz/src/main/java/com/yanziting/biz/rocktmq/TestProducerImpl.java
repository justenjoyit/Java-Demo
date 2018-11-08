package com.yanziting.biz.rocktmq;

import com.google.common.collect.Lists;
import com.yanziting.biz.rocktmq.message.OrderMessage;
import com.yanziting.biz.rocktmq.producer.MessageProducer;
import com.yanziting.biz.rocktmq.producer.ReceiptProducer;


import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @author : Ziting.Yan
 * @since : 2018-10-31-20-58
 **/
@Service
public class TestProducerImpl {

    @Resource
    private ReceiptProducer receiptProducer;
    @Resource
    private MessageProducer messageProducer;

    public void send() throws Exception {
        for (int i = 0; i < 10; ++i) {
            OrderMessage orderMessage = OrderMessage.builder()
                .orderId(String.valueOf(i))
                .userId(String.valueOf(i))
                .productIds(Lists.newArrayList(String.valueOf(i)))
                .created(new Date())
                .build();
            messageProducer.sendOrderMessage(orderMessage);
            receiptProducer.sendMessage("order producer send message: " + i);
        }
    }
}
