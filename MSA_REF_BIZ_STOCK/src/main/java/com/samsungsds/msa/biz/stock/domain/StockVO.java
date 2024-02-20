package com.samsungsds.msa.biz.stock.domain;

import lombok.Data;

@Data
public class StockVO {
    private long id;
    private String origin;
    private String type;
    private int count;
    private int cost;
}
