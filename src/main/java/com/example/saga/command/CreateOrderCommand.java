package com.example.saga.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateOrderCommand {

    @TargetAggregateIdentifier
    public final String orderId;
    public final String description;
    public final String testId;

    public CreateOrderCommand(String orderId,String description,String testId)
    {
        this.orderId=orderId;
        this.description=description;
        this.testId=testId;
    }
}
