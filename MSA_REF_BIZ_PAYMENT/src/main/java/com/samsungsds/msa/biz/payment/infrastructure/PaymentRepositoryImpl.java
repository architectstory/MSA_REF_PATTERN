package com.samsungsds.msa.biz.payment.infrastructure;

import com.samsungsds.msa.biz.payment.domain.PaymentAggregate;
import com.samsungsds.msa.biz.payment.domain.PaymentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    private final Logger logger = LogManager.getLogger(PaymentRepositoryImpl.class);
   @Autowired
   H2Repository h2Repository;

    @Override
    public void createPayment(PaymentAggregate paymentAggregate) {
        PaymentDVO paymentDVO = new PaymentDVO();
        paymentDVO.setId(paymentAggregate.getId());
        paymentDVO.setType(paymentAggregate.getType());
        paymentDVO.setOrigin(paymentAggregate.getOrigin());
        paymentDVO.setCost(paymentAggregate.getCost());
        paymentDVO.setCount(paymentAggregate.getCount());

        h2Repository.save(paymentDVO);
    }

    @Override
    public List<PaymentAggregate> readPayment() {

        List<PaymentAggregate> paymentAggregateList = new ArrayList<>();
        List<PaymentDVO> paymentDVOList = h2Repository.findAll();
        for(PaymentDVO paymentDVO : paymentDVOList){
            PaymentAggregate paymentAggregate = new PaymentAggregate();
            paymentAggregate.setId(paymentDVO.getId());
            paymentAggregate.setType(paymentDVO.getType());
            paymentAggregate.setOrigin(paymentDVO.getOrigin());
            paymentAggregate.setCost(paymentDVO.getCost());
            paymentAggregate.setCount(paymentDVO.getCount());
            paymentAggregateList.add(paymentAggregate);
        }
        return paymentAggregateList;
    }

    @Override
    public void updatePayment(PaymentAggregate paymentAggregate) {
        PaymentDVO paymentDVO = getPaymentDVO(paymentAggregate);
        paymentDVO.setId(paymentAggregate.getId());
        h2Repository.save(paymentDVO);
    }

    @Override
    public void deletePayment(PaymentAggregate paymentAggregate) {
        PaymentDVO paymentDVO = getPaymentDVO(paymentAggregate);
        paymentDVO.setId(paymentAggregate.getId());
        h2Repository.delete(paymentDVO);
    }
    private PaymentDVO getPaymentDVO(PaymentAggregate paymentAggregate){
        PaymentDVO paymentDVO = new PaymentDVO();
        paymentDVO.setId(paymentAggregate.getId());
        paymentDVO.setOrigin(paymentAggregate.getOrigin());
        paymentDVO.setType(paymentAggregate.getType());
        paymentDVO.setCount(paymentAggregate.getCount());
        paymentDVO.setCost(paymentAggregate.getCost());
        return paymentDVO;
    }
}
