package com.williams.myStock.exception;

public abstract class StockApiException extends RuntimeException {

    StockApiException(String message){super(message);}

    StockApiException (String message, Throwable cause){
        super(message,cause);
        if(this.getCause() == null && cause != null){
            this.initCause(cause);
        }
    }
}
