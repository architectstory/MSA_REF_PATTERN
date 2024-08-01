package com.samsungsds.msa.biz.order.application;

import com.samsungsds.msa.biz.order.application.OrderDTO;

import java.util.List;

public interface OrderService {

    void createOrder(OrderDTO orderDTO);
    List<OrderDTO> readOrder();
    void updateOrder(OrderDTO orderDTO);
    void deleteOrder(OrderDTO orderDTO);
}
