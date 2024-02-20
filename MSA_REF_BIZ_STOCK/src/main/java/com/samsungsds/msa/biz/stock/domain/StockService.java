package com.samsungsds.msa.biz.stock.domain;

import com.samsungsds.msa.biz.stock.application.StockDTO;

import java.util.List;

public interface StockService {

    void createStock(StockDTO stockDTO);
    List<StockDTO> readStock();
    void updateStock(StockDTO stockDTO);
    void deleteStock(StockDTO stockDTO);
}
