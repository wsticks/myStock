package com.williams.myStock.repository;

import com.williams.myStock.model.entity.Stocks;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends PagingAndSortingRepository<Stocks, Long>, QueryDslPredicateExecutor<Stocks> {

    Stocks findOneByUniqueKey(String uniqueKey);
    List<Stocks> findAll();
}
