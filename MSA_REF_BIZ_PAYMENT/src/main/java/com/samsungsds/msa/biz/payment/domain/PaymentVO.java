package com.samsungsds.msa.biz.payment.domain;

import lombok.Data;

@Data
public class PaymentVO {
    private long id;
    private String origin;
    private String type;
    private int count;
    private int cost;
}
