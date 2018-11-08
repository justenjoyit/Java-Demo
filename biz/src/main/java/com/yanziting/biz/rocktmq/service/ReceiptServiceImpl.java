package com.yanziting.biz.rocktmq.service;

import com.yanziting.biz.rocktmq.message.ReceiptMessage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-08-19-16
 **/
@Service
@Slf4j
public class ReceiptServiceImpl {

    public void handleReceipt(ReceiptMessage receiptMessage) throws InterruptedException {
        log.info("handle receipt {} ....", receiptMessage);
        Thread.sleep(1000);
        log.info("handle receipt {} end .....", receiptMessage);
    }
}
