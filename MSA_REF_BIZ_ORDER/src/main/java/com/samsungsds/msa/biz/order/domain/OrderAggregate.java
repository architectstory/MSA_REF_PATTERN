package com.samsungsds.msa.biz.order.domain;

import lombok.Data;

@Data
public class OrderAggregate {

    private long id;
    private String origin;
    private String type;
    private int count;
    private int cost;

    public OrderAggregate createOrder(OrderVO orderVO){
        this.setId(orderVO.getId());
        this.setType(orderVO.getType());
        this.setCost(orderVO.getCost());
        this.setCount(orderVO.getCount());
        this.setOrigin(orderVO.getOrigin());
        return this;
    }
    public OrderAggregate updateOrder(OrderVO orderVO){
        this.setId(orderVO.getId());
        this.setType(orderVO.getType());
        this.setCost(orderVO.getCost());
        this.setCount(orderVO.getCount());
        this.setOrigin(orderVO.getOrigin());
        return this;
    }

    public void deleteOrder(OrderVO orderVO){
        this.setId(orderVO.getId());
        this.setType(orderVO.getType());
        this.setCost(orderVO.getCost());
        this.setCount(orderVO.getCount());
        this.setOrigin(orderVO.getOrigin());
    }

}