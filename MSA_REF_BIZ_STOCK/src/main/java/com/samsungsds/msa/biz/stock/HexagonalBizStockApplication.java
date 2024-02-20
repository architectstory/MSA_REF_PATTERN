package com.samsungsds.msa.biz.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.samsungsds.msa")
public class HexagonalBizStockApplication {
    public static void main(String[] args){
        SpringApplication.run(HexagonalBizStockApplication.class, args);
    }
}