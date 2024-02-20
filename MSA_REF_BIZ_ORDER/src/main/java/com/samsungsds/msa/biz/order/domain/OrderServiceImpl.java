package com.samsungsds.msa.biz.order.domain;

import com.samsungsds.msa.biz.order.application.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(OrderDTO orderDTO) {

        OrderAggregate orderAggregate = new OrderAggregate();

        OrderVO orderVO = new OrderVO();
        orderVO.setId(orderDTO.getId());
        orderVO.setType(orderDTO.getType());
        orderVO.setCount(orderDTO.getCount());
        orderVO.setCost(orderDTO.getCost());
        orderVO.setOrigin(orderDTO.getOrigin());

        orderAggregate.createOrder(orderVO);

        orderRepository.createOrder(orderAggregate);
    }

    @Override
    public List<OrderDTO> readOrder() {

        List<OrderAggregate> orderAggregateList = orderRepository.readOrder();

        List<OrderDTO> orderDTOList = new ArrayList<>();
        for(OrderAggregate orderAggregate: orderAggregateList){
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(orderAggregate.getId());
            orderDTO.setType(orderAggregate.getType());
            orderDTO.setOrigin(orderAggregate.getOrigin());
            orderDTO.setCost(orderAggregate.getCost());
            orderDTO.setCount(orderAggregate.getCount());
            orderDTOList.add(orderDTO);
        }

        return orderDTOList;
    }
    @Override
    public void updateOrder(OrderDTO orderDTO) {

        OrderVO orderVO = new OrderVO();
        orderVO.setId(orderDTO.getId());
        orderVO.setType(orderDTO.getType());
        orderVO.setCount(orderDTO.getCount());
        orderVO.setCost(orderDTO.getCost());
        orderVO.setOrigin(orderDTO.getOrigin());

        OrderAggregate orderAggregate = new OrderAggregate();
        orderAggregate.updateOrder(orderVO);

        orderRepository.updateOrder(orderAggregate);
    }

    @Override
    public void deleteOrder(OrderDTO orderDTO) {
        OrderAggregate orderAggregate = new OrderAggregate();

        OrderVO orderVO = new OrderVO();
        orderVO.setId(orderDTO.getId());
        orderVO.setType(orderDTO.getType());
        orderVO.setCount(orderDTO.getCount());
        orderVO.setCost(orderDTO.getCost());
        orderVO.setOrigin(orderDTO.getOrigin());

        orderAggregate.deleteOrder(orderVO);

        orderRepository.deleteOrder(orderAggregate);
    }
}
