package com.samsungsds.msa.biz.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.samsungsds.msa")
public class HexagonalBizOrderApplication {
    public static void main(String[] args){
        SpringApplication.run(HexagonalBizOrderApplication.class, args);
    }
}