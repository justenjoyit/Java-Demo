package com.yanziting.biz.rocktmq.message;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-08-15-47
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptMessage implements Serializable {
    private String shipId;
    private String orderId;
    private String receiver;
    private Date receiveTime;
}
