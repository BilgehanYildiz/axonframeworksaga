package com.example.saga.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CompensateTestEntityCommand {
    @TargetAggregateIdentifier
    public final String id;
    public final int status;


    public CompensateTestEntityCommand(String id,int status)
    {
        this.id=id;
        this.status=status;
    }
}
