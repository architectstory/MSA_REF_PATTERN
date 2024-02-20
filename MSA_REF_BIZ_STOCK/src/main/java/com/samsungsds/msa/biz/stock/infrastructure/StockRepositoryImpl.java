package com.samsungsds.msa.biz.stock.infrastructure;

import com.samsungsds.msa.biz.stock.domain.StockAggregate;
import com.samsungsds.msa.biz.stock.domain.StockRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StockRepositoryImpl implements StockRepository {

    private final Logger logger = LogManager.getLogger(StockRepositoryImpl.class);
    @Autowired
    H2Repository h2Repository;

    @Override
    public void createStock(StockAggregate stockAggregate) {

    }

    @Override
    public List<StockAggregate> readStock() {
        return null;
    }

    @Override
    public void updateStock(StockAggregate stockAggregate) {

    }

    @Override
    public void deleteStock(StockAggregate stockAggregate) {

    }
}
