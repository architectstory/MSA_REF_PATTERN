package com.samsungsds.msa.biz.order.infrastructure;

import com.samsungsds.msa.biz.order.domain.OrderAggregate;
import com.samsungsds.msa.biz.order.domain.OrderRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

   private final Logger logger = LogManager.getLogger(OrderRepositoryImpl.class);
   @Autowired
   H2Repository h2Repository;

    @Override
    public void createOrder(OrderAggregate orderAggregate) {
        OrderDVO orderDVO = new OrderDVO();
        orderDVO.setId(orderAggregate.getId());
        orderDVO.setType(orderAggregate.getType());
        orderDVO.setOrigin(orderAggregate.getOrigin());
        orderDVO.setCost(orderAggregate.getCost());
        orderDVO.setCount(orderAggregate.getCount());

        h2Repository.save(orderDVO);
    }

    @Override
    public List<OrderAggregate> readOrder() {

        List<OrderAggregate> orderAggregateList = new ArrayList<>();
        List<OrderDVO> orderDVOList = h2Repository.findAll();
        for(OrderDVO orderDVO: orderDVOList){
            OrderAggregate orderAggregate = new OrderAggregate();
            orderAggregate.setId(orderDVO.getId());
            orderAggregate.setType(orderDVO.getType());
            orderAggregate.setOrigin(orderDVO.getOrigin());
            orderAggregate.setCost(orderDVO.getCost());
            orderAggregate.setCount(orderDVO.getCount());
            orderAggregateList.add(orderAggregate);
        }
        return orderAggregateList;
    }

    @Override
    public void updateOrder(OrderAggregate orderAggregate) {
        OrderDVO orderDVO = getOrderDVO(orderAggregate);
        orderDVO.setId(orderAggregate.getId());
        h2Repository.save(orderDVO);
    }

    @Override
    public void deleteOrder(OrderAggregate orderAggregate) {
        OrderDVO orderDVO = getOrderDVO(orderAggregate);
        orderDVO.setId(orderAggregate.getId());
        h2Repository.delete(orderDVO);
    }
    private OrderDVO getOrderDVO(OrderAggregate orderAggregate){
        OrderDVO orderDVO = new OrderDVO();
        orderDVO.setId(orderAggregate.getId());
        orderDVO.setOrigin(orderAggregate.getOrigin());
        orderDVO.setType(orderAggregate.getType());
        orderDVO.setCount(orderAggregate.getCount());
        orderDVO.setCost(orderAggregate.getCost());
        return orderDVO;
    }
}
