package com.yanziting.biz.rocktmq;

import com.yanziting.biz.rocktmq.producer.OrderProducer;
import com.yanziting.biz.rocktmq.producer.ReceiptProducer;
import com.yanziting.biz.rocktmq.producer.ShipProducer;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @author : Ziting.Yan
 * @since : 2018-10-31-20-58
 **/
@Service
public class TestProducerImpl {

    @Resource
    private OrderProducer orderProducer;
    @Resource
    private ShipProducer shipProducer;
    @Resource
    private ReceiptProducer receiptProducer;

    public void send() throws Exception {
        for (int i = 0; i < 10; ++i) {
            orderProducer.sendMessage("order producer send message: " + i);
            shipProducer.sendMessage("order producer send message: " + i);
            receiptProducer.sendMessage("order producer send message: " + i);
        }
    }
}
