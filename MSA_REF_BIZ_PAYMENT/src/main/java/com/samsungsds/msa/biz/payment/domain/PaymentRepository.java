package com.samsungsds.msa.biz.payment.domain;

import java.util.List;

public interface PaymentRepository {
    void createPayment(PaymentAggregate paymentAggregate);

    List<PaymentAggregate> readPayment();

    void updatePayment(PaymentAggregate paymentAggregate);

    void deletePayment(PaymentAggregate paymentAggregate);
}