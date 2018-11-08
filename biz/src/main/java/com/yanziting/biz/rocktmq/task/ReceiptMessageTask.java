package com.yanziting.biz.rocktmq.task;

import com.yanziting.biz.rocktmq.producer.ReceiptProducer;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-08-15-54
 **/
@Slf4j
public class ReceiptMessageTask {

    private Object data;
    private ReceiptProducer receiptProducer;

    public ReceiptMessageTask(ReceiptProducer receiptProducer, Object data) {
        this.receiptProducer = receiptProducer;
        this.data = data;
    }

    public void send() throws InterruptedException, IOException, RemotingException, MQClientException, MQBrokerException {
        receiptProducer.sendMessage(data);
    }
}
