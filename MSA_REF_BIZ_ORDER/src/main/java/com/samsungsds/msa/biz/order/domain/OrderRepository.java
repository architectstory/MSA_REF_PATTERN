package com.samsungsds.msa.biz.order.domain;

import java.util.List;

public interface OrderRepository {
    void createOrder(OrderAggregate orderAggregate);

    List<OrderAggregate> readOrder();

    void updateOrder(OrderAggregate orderAggregate);

    void deleteOrder(OrderAggregate orderAggregate);
}
