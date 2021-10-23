package com.example.saga.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateTestEntityCommand {
    @TargetAggregateIdentifier
    public final String id;
    public final int status;


    public UpdateTestEntityCommand(String id, int status)
    {
        this.id=id;
        this.status=status;
    }

}

