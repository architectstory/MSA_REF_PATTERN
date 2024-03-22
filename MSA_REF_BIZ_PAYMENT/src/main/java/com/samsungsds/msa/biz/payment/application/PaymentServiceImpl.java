package com.samsungsds.msa.biz.payment.application;

import com.samsungsds.msa.biz.payment.domain.PaymentAggregate;
import com.samsungsds.msa.biz.payment.domain.PaymentRepository;
import com.samsungsds.msa.biz.payment.domain.PaymentVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;
    public PaymentServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void createPayment(PaymentDTO paymentDTO) {
        PaymentAggregate paymentAggregate = new PaymentAggregate();

        PaymentVO paymentVO = new PaymentVO();
        paymentVO.setId(paymentDTO.getId());
        paymentVO.setOrigin(paymentDTO.getOrigin());
        paymentVO.setType(paymentDTO.getType());
        paymentVO.setCount(paymentDTO.getCount());
        paymentVO.setCost(paymentDTO.getCost());

        paymentAggregate.createPayment(paymentVO);

        paymentRepository.createPayment(paymentAggregate);
    }
    @Override
    public List<PaymentDTO> readPayment() {

        List<PaymentAggregate> paymentAggregateList = paymentRepository.readPayment();

        List<PaymentDTO> paymentDTOList = new ArrayList<>();
        for(PaymentAggregate paymentAggregate : paymentAggregateList){
            PaymentDTO paymentDTO = new PaymentDTO();
            paymentDTO.setId(paymentAggregate.getId());
            paymentDTO.setOrigin(paymentAggregate.getOrigin());
            paymentDTO.setType(paymentAggregate.getType());
            paymentDTO.setCount(paymentAggregate.getCount());
            paymentDTO.setCost(paymentAggregate.getCost());

            paymentDTOList.add(paymentDTO);
        }
        return paymentDTOList;
    }
    @Override
    public void updatePayment(PaymentDTO paymentDTO) {

        PaymentAggregate paymentAggregate = new PaymentAggregate();

        PaymentVO paymentVO = new PaymentVO();
        paymentVO.setId(paymentDTO.getId());
        paymentVO.setType(paymentDTO.getType());
        paymentVO.setCount(paymentDTO.getCount());
        paymentVO.setCost(paymentDTO.getCost());
        paymentVO.setOrigin(paymentDTO.getOrigin());

        paymentAggregate.updatePayment(paymentVO);

        paymentRepository.updatePayment(paymentAggregate);
    }

    @Override
    public void deletePayment(PaymentDTO paymentDTO) {
        PaymentAggregate paymentAggregate = new PaymentAggregate();

        PaymentVO paymentVO = new PaymentVO();
        paymentVO.setId(paymentDTO.getId());
        paymentVO.setType(paymentDTO.getType());
        paymentVO.setCount(paymentDTO.getCount());
        paymentVO.setCost(paymentDTO.getCost());
        paymentVO.setOrigin(paymentDTO.getOrigin());

        paymentAggregate.deletePayment(paymentVO);

        paymentRepository.deletePayment(paymentAggregate);
    }

}