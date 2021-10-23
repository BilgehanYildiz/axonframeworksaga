package com.example.saga.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteTestEntityCommand {
    @TargetAggregateIdentifier
    public final String id;
    public final int status;


    public DeleteTestEntityCommand(String id, int status)
    {
        this.id=id;
        this.status=status;
    }

}

