package com.samsungsds.msa.biz.payment.infrastructure;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="TB_PAYMENT")
@Data
public class PaymentDVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String origin;
    private String type;
    private int count;
    private int cost;
}