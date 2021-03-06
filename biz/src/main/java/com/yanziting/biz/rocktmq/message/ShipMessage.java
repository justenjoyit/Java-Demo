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
 * @since : 2018-11-08-07-40
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipMessage implements Serializable {
    private String shipId;
    private String orderId;
    private List<String> productIds;
    private Double totalWeight;
    private Date created;
}
