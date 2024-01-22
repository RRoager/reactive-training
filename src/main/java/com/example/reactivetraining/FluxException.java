package com.example.reactivetraining;

public class FluxException extends Throwable{
    private Throwable throwable;
    private String message;

    public FluxException(Throwable throwable, String message) {
        this.throwable = throwable;
        this.message = message;
    }
}
