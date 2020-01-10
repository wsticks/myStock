package com.williams.myStock.Service.facade;

import com.williams.myStock.Service.StockService;
import com.williams.myStock.model.entity.Stocks;
import com.williams.myStock.model.request.UpsertStockRequest;
import com.williams.myStock.model.response.StockResponse;
import com.williams.myStock.model.response.SuccesResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AccountFacade {

    private final StockService stockService;

    public AccountFacade(StockService stockService) {
        this.stockService = stockService;
    }

    public SuccesResponse createStock(UpsertStockRequest upsertStockRequest){
        StockResponse stock = stockService.prepareStockForSave(upsertStockRequest);
        Map<String, Object> data = new HashMap<>();
        data.put("stock", stock);
        SuccesResponse successResponse = SuccesResponse.builder().data(data).build();
        return successResponse;

    }

    public SuccesResponse updateStock(UpsertStockRequest upsertStockRequest){
        Stocks stocks = stockService.prepareStockForUpdate(upsertStockRequest.toStock(), upsertStockRequest.getUniqueKey());
        StockResponse stockResponse = StockResponse.fronStock(stocks);
        Map<String, Object> data = new HashMap<>();
        data.put("stock", stockResponse);
        SuccesResponse succesResponse = SuccesResponse.builder().data(data).build();
        return succesResponse;
    }

    public SuccesResponse viewStock(String uniqueKey){
        Stocks stocks = stockService.viewStock(uniqueKey);
        StockResponse stockResponse = StockResponse.fronStock(stocks);
        Map<String, Object> data = new HashMap<>();
        data.put("stock", stockResponse);
        SuccesResponse succesResponse = SuccesResponse.builder().data(data).build();
        return succesResponse;
    }

    public List<Stocks> getAllStock(UpsertStockRequest upsertStockRequest){
        List<Stocks> stocks = stockService.findAllStocks(upsertStockRequest);
        return stocks;
    }
}
