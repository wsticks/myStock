package com.williams.myStock.model.response;

import com.williams.myStock.model.entity.Stocks;
import com.williams.myStock.util.TimeUtil;
import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class StockResponse {

    private String uniqueKey;
    private String firstStock;
    private String secondStock;
    private String thirdStock;
    private String fourthStock;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public static StockResponse fronStock(Stocks stocks){
        return StockResponse.builder()
                .createdAt(TimeUtil.getIsoTime(stocks.getCreatedAt()))
                .updatedAt(TimeUtil.getIsoTime(stocks.getUpdatedAt()))
                .firstStock(stocks.getFirstStock())
                .secondStock(stocks.getSecondStock())
                .thirdStock(stocks.getThirdStock())
                .fourthStock(stocks.getFourthStock())
                .uniqueKey(stocks.getUniqueKey(uniqueKey))
                .build();
    }
}
