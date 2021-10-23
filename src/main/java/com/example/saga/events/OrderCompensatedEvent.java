package com.example.saga.events;

public class OrderCompensatedEvent {

    public final String orderId;
    public final String testId;

    public OrderCompensatedEvent(String orderId, String testId)
    {
        this.orderId=orderId;

        this.testId=testId;
    }
}
