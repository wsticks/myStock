package com.williams.myStock.model.response;

import com.williams.myStock.model.constant.Status;
import lombok.*;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
public class SuccesResponse  extends StockApiResponse{

    private Status status;
    private Map<String, Object> data;
}
