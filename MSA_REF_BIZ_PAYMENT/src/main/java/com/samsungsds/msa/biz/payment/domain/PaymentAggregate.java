package com.samsungsds.msa.biz.payment.domain;


import lombok.Data;

@Data
public class PaymentAggregate {
    private long id;
    private String origin;
    private String type;
    private int count;
    private int cost;

    public PaymentAggregate createPayment(PaymentVO paymentVO){
        this.setId(paymentVO.getId());
        this.setType(paymentVO.getType());
        this.setCost(paymentVO.getCost());
        this.setCount(paymentVO.getCount());
        this.setOrigin(paymentVO.getOrigin());
        return this;
    }
    public void updatePayment(PaymentVO paymentVO){
        this.setId(paymentVO.getId());
        this.setType(paymentVO.getType());
        this.setCost(paymentVO.getCost());
        this.setCount(paymentVO.getCount());
        this.setOrigin(paymentVO.getOrigin());
    }

    public void deletePayment(PaymentVO paymentVO){
        this.setId(paymentVO.getId());
        this.setType(paymentVO.getType());
        this.setCost(paymentVO.getCost());
        this.setCount(paymentVO.getCount());
        this.setOrigin(paymentVO.getOrigin());
    }
}