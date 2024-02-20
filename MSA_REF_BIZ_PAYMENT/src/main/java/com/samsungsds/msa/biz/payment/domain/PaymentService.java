package com.samsungsds.msa.biz.payment.domain;

import com.samsungsds.msa.biz.payment.application.PaymentDTO;

import java.util.List;

public interface PaymentService {

    void createPayment(PaymentDTO paymentDTO);
    List<PaymentDTO> readPayment();
    void updatePayment(PaymentDTO paymentDTO);
    void deletePayment(PaymentDTO paymentDTO);
}
