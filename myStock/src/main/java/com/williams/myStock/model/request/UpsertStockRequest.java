package com.williams.myStock.model.request;

import com.williams.myStock.model.entity.Stocks;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class UpsertStockRequest {

    private String firstStock;
    private String secondStock;
    private String thirdStock;
    private String fourthStock;
    private String uniqueKey;


    public Stocks toStock(){
        Stocks stocks = new Stocks();
        stocks.setFirstStock(firstStock);
        stocks.setSecondStock(secondStock);
        stocks.setThirdStock(thirdStock);
        stocks.setFourthStock(fourthStock);
        stocks.getUniqueKey(uniqueKey);
        return stocks;
    }
}
