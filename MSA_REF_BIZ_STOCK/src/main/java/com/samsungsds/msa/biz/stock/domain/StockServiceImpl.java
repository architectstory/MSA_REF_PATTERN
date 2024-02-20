package com.samsungsds.msa.biz.stock.domain;

import com.samsungsds.msa.biz.stock.application.StockDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    @Override
    public void createStock(StockDTO stockDTO) {

    }

    @Override
    public List<StockDTO> readStock() {
        return null;
    }

    @Override
    public void updateStock(StockDTO stockDTO) {

    }

    @Override
    public void deleteStock(StockDTO stockDTO) {

    }
}
