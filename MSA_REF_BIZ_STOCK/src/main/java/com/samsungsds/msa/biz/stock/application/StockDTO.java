package com.samsungsds.msa.biz.stock.application;

import lombok.Data;

@Data
public class StockDTO {
    private long id;
    private String origin;
    private String type;
    private int count;
    private int cost;
}
