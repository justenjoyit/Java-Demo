package com.yanziting.biz.rocktmq.service;

import com.yanziting.biz.rocktmq.message.ReceiptMessage;
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
 * @since : 2018-11-08-15-45
 **/
@Service
@Slf4j
public class ShipServiceImpl {

    @Resource
    private MessageProducer messageProducer;

    private void ship(ShipMessage shipMessage) throws InterruptedException {
        log.info("package {} ship in the way.....", shipMessage);
        Thread.sleep(1000);
        log.info("package {} ship arrived.....", shipMessage);
    }

    public void handleShip(ShipMessage shipMessage) throws InterruptedException, IOException, RemotingException, MQClientException, MQBrokerException {
        ship(shipMessage);
        ReceiptMessage receiptMessage = ReceiptMessage.builder()
            .orderId(shipMessage.getOrderId())
            .shipId(shipMessage.getShipId())
            .receiver("Receiver" + RandomUtils.nextInt())
            .receiveTime(new Date())
            .build();
        messageProducer.sendReceiptMessage(receiptMessage);
    }
}
