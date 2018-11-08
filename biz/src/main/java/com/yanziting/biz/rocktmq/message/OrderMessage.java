package com.yanziting.biz.rocktmq.message;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Ziting.Yan
 * @since : 2018-11-07-21-36
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderMessage implements Serializable {
    private String orderId;
    private String userId;
    private List<String> productIds;
    private Date created;
}
