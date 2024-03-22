package com.samsungsds.msa.biz.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.samsungsds.msa")
public class HexagonalBizPaymentApplication {
    public static void main(String[] args){
        SpringApplication.run(HexagonalBizPaymentApplication.class, args);
    }
}