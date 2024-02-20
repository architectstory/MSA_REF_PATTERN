package com.samsungsds.msa.biz.payment.application;

import lombok.Data;

@Data
public class PaymentDTO {
    private long id;
    private String origin;
    private String type;
    private int count;
    private int cost;
}
