package com.samsungsds.msa.biz.stock.domain;

import java.util.List;

public interface StockRepository {
    void createStock(StockAggregate stockAggregate);

    List<StockAggregate> readStock();

    void updateStock(StockAggregate stockAggregate);

    void deleteStock(StockAggregate stockAggregate);
}
