package com.williams.myStock.Service;

import com.williams.myStock.model.entity.Stocks;
import com.williams.myStock.exception.ProcessingException;
import com.williams.myStock.model.response.StockResponse;
import com.williams.myStock.repository.StockRepository;
import com.williams.myStock.model.request.UpsertStockRequest;
import com.williams.myStock.util.SecurityUtil;
import com.williams.myStock.util.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;
    private final String STOCK_EXIST = "Stock already exists";
    private final String STOCK_NOT_FOUND = "Sock to update was not found";

    public StockService(StockRepository stockRepository) {
        Assert.notNull(stockRepository);
        this.stockRepository = stockRepository;
    }

    public StockResponse prepareStockForSave(UpsertStockRequest upsertStockRequest){
        Stocks stocksToSave =upsertStockRequest.toStock();
        generateUniqueKey(stocksToSave);
        Stocks savedStocks = stockRepository.save(stocksToSave);
        StockResponse stockResponse = new StockResponse();
        stockResponse.setCreatedAt(TimeUtil.getIsoTime(savedStocks.getUpdatedAt()));
        stockResponse.setUpdatedAt(TimeUtil.getIsoTime(savedStocks.getUpdatedAt()));
        stockResponse.setFirstStock(savedStocks.getFirstStock());
        stockResponse.setSecondStock(savedStocks.getSecondStock());
        stockResponse.setThirdStock(savedStocks.getThirdStock());
        stockResponse.setFourthStock(savedStocks.getFourthStock());
        stockResponse.setUniqueKey(savedStocks.getUniqueKey());
        return stockResponse;
    }

    public Stocks prepareStockForUpdate(Stocks stockTosave, String uniqueKey){
        Stocks savedStock = fetchStockByUniqueKey(uniqueKey);
        savedStock.setFirstStock(stockTosave.getFirstStock());
        savedStock.setSecondStock(stockTosave.getSecondStock());
        savedStock.setThirdStock(stockTosave.getThirdStock());
        savedStock.setFourthStock(stockTosave.getFourthStock());
        return stockRepository.save(savedStock);
    }

    private void generateUniqueKey(Stocks stocks) throws ProcessingException {
        String uniqueKey = null;
        if (stocks.getUniqueKey(uniqueKey) != null) {
            return;
        }
        String rawKey = stocks.getFirstStock() + LocalDateTime.now() + Math.random() + stocks.getThirdStock();
        uniqueKey = SecurityUtil.hashWithMd5(rawKey);
        stocks.setUniqueKey(uniqueKey);
    }

    private Stocks fetchStockByUniqueKey(String uniqueKey){
        Stocks savedStock = stockRepository.findOneByUniqueKey(uniqueKey);
        if(savedStock == null){
            throw new ProcessingException("Staff not found");
        }
        return savedStock;

    }

    public Stocks viewStock(String uniqueKey){
        Stocks savedStock = fetchStockByUniqueKey(uniqueKey);
        return savedStock;
    }

    public List<Stocks> findAllStocks(UpsertStockRequest upsertStockRequest){
        return stockRepository.findAll();
    }
}
