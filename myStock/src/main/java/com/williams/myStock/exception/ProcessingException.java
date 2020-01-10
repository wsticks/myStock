package com.williams.myStock.exception;

public class ProcessingException  extends  StockApiException {

    public ProcessingException(String message) {
        super(message);
    }

    public ProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

}

