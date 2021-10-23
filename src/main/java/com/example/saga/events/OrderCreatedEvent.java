package com.example.saga.events;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class OrderCreatedEvent {

    public final String orderId;
    public final String description;
    public final String testId;

    public OrderCreatedEvent(String orderId,String description,String testId)
    {
        this.orderId=orderId;
        this.description=description;
        this.testId=testId;
    }
}
