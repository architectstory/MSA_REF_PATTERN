package com.samsungsds.msa.biz.order.domain;

import lombok.Data;

@Data
public class OrderVO {
    private long id;
    private String origin;
    private String type;
    private int count;
    private int cost;
}
