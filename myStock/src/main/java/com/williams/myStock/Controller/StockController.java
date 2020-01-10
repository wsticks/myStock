package com.williams.myStock.Controller;

import com.williams.myStock.Service.facade.AccountFacade;
import com.williams.myStock.model.entity.Stocks;
import com.williams.myStock.model.request.UpsertStockRequest;
import com.williams.myStock.model.response.StockApiResponse;
import com.williams.myStock.model.response.SuccesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/stock")

public class StockController {

   private final AccountFacade accountFacade;

    public StockController(AccountFacade accountFacade) {
        Assert.notNull(accountFacade);
        this.accountFacade = accountFacade;
    }


    @Transactional
    @RequestMapping(method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<StockApiResponse> createRecruitedStaff(
            @RequestBody UpsertStockRequest upsertStockRequest) {
        SuccesResponse succesResponse = accountFacade.createStock(upsertStockRequest);
        return new ResponseEntity<>(succesResponse, HttpStatus.CREATED);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.PUT,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<StockApiResponse> updateStock(
            @RequestBody UpsertStockRequest upsertStockRequest) {
        SuccesResponse succesResponse = accountFacade.updateStock(upsertStockRequest);
        return new
                ResponseEntity<>(succesResponse, HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, path = "/{staffKey}",
            produces = "application/json")
    public ResponseEntity<StockApiResponse> viewStock( @PathVariable String stockKey) {

        SuccesResponse successResponse = accountFacade.viewStock(stockKey);
        return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
    }



    @Transactional
    @RequestMapping(method = RequestMethod.GET,
            produces = "application/json")
    public List<Stocks> getAllStock(@RequestHeader UpsertStockRequest request) {
        List<Stocks> successResponse = accountFacade.getAllStock( request);
        return successResponse;
    }
}
