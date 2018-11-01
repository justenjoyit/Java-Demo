package com.yanziting.biz.rocktmq;


/**
 * @author : Ziting.Yan
 * @since : 2018-10-31-20-46
 **/
public class TestProducer {

    public static void main(String[] args) throws Exception {

        TestProducerImpl testProducer = new TestProducerImpl();
        testProducer.send();
    }
}
