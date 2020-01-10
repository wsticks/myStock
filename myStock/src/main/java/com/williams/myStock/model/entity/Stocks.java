package com.williams.myStock.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "stock")
public class Stocks  implements Serializable{

    private String uniqueKey;
    private String firstStock;
    private String secondStock;
    private String thirdStock;
    private String fourthStock;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public String getUniqueKey(String uniqueKey) { return this.uniqueKey; }

    public void setUniqueKey(String uniqueKey) { this.uniqueKey = uniqueKey; }

    public String getFirstStock() { return firstStock; }

    public void setFirstStock(String firstStock) { this.firstStock = firstStock; }

    public String getSecondStock() { return secondStock; }

    public void setSecondStock(String secondStock) { this.secondStock = secondStock; }

    public String getThirdStock() { return thirdStock; }

    public void setThirdStock(String thirdStock) { this.thirdStock = thirdStock; }

    public String getFourthStock() { return fourthStock; }

    public void setFourthStock(String fourthStock) { this.fourthStock = fourthStock; }

    public Timestamp getCreatedAt() { return createdAt; }

    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public Timestamp getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }

    public String getUniqueKey() {
        return uniqueKey;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stocks stocks = (Stocks) o;
        return Objects.equals(uniqueKey, stocks.uniqueKey) &&
                Objects.equals(firstStock, stocks.firstStock) &&
                Objects.equals(secondStock, stocks.secondStock) &&
                Objects.equals(thirdStock, stocks.thirdStock) &&
                Objects.equals(fourthStock, stocks.fourthStock) &&
                Objects.equals(createdAt, stocks.createdAt) &&
                Objects.equals(updatedAt, stocks.updatedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uniqueKey, firstStock, secondStock, thirdStock, fourthStock, createdAt, updatedAt);
    }
}
