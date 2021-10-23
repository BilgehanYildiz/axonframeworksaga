package com.example.saga.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateTestEntityCommand {
    @TargetAggregateIdentifier
    public final String id;
    public final String name;
    public final String info;


    public CreateTestEntityCommand(String id,String name)
    {
        this.id=id;
        this.name=name;
        this.info="Test Entity creation will be requested";
    }

}

