package com.samsungsds.msa.biz.order.application;

import lombok.Data;

@Data
public class OrderDTO {
    private long id;
    private String origin;
    private String type;
    private int count;
    private int cost;
}
