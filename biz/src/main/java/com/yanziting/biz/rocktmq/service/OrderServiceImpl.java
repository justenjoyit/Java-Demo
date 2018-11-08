package com.yanziting.biz.rocktmq.service;

import com.yanziting.biz.rocktmq.message.OrderMessage;
import com.yanziting.biz.rocktmq.message.ShipMessage;
import com.yanziting.biz.rocktmq.producer.MessageProducer;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-08-07-55
 **/
@Service
@Slf4j
public class OrderServiceImpl {

    @Resource
    private MessageProducer messageProducer;

    /**
     * 订单下单
     */
    private void order(OrderMessage orderMessage) throws InterruptedException {
        if (null == orderMessage) {
            return;
        }
        log.info("order start .....");
        Thread.sleep(1000);
        log.info("user {} order product {} at {} ,orderId is {}", orderMessage.getUserId(), orderMessage.getProductIds(), orderMessage.getCreated(),
            orderMessage.getOrderId());
        Thread.sleep(1000);
        log.info("order end .....");
    }

    /**
     * 卖家备货
     */
    private void prepare(String orderId) throws InterruptedException {
        log.info("seller is preparing for orderId {}", orderId);
        Thread.sleep(1000);
    }

    /**
     * 处理订单 --- 下单->备货->发货
     */
    public void handleOrder(OrderMessage orderMessage) throws InterruptedException, IOException, RemotingException, MQClientException, MQBrokerException {
        order(orderMessage);
        prepare(orderMessage.getOrderId());
        //发货
        ShipMessage shipMessage = ShipMessage.builder()
            .shipId("S" + RandomUtils.nextLong() + new Date())
            .orderId(orderMessage.getOrderId())
            .productIds(orderMessage.getProductIds())
            .totalWeight(RandomUtils.nextDouble())
            .created(new Date())
            .build();
        log.info("ship order {}", shipMessage);
        messageProducer.sendShipMessage(shipMessage);
    }
}
