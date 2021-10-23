package com.example.saga.aggregate;

import com.example.saga.command.CompensateTestEntityCommand;
import com.example.saga.command.CreateTestEntityCommand;
import com.example.saga.command.DeleteTestEntityCommand;
import com.example.saga.command.UpdateTestEntityCommand;
import com.example.saga.events.TestEntityCompensatedEvent;
import com.example.saga.events.TestEntityCreatedEvent;
import com.example.saga.events.TestEntityDeletedEvent;
import com.example.saga.events.TestEntityUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateCreationPolicy;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.CreationPolicy;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class TestAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String info;
    private int status;


    public TestAggregate(){}

    @CommandHandler
    public TestAggregate(CreateTestEntityCommand command)
    {
        AggregateLifecycle.apply(new TestEntityCreatedEvent(command.id,command.name));
    }

    @EventSourcingHandler
    protected void on(TestEntityCreatedEvent testEntityCreatedEvent){

        this.id=testEntityCreatedEvent.id;
        this.name=testEntityCreatedEvent.name;
        this.info=testEntityCreatedEvent.info;
    }

    @CommandHandler
    public void updateTestAggregate(UpdateTestEntityCommand command)
    {
        AggregateLifecycle.apply(new TestEntityUpdatedEvent(command.id,command.status));
    }

    @EventSourcingHandler
    protected void on(TestEntityUpdatedEvent testEntityUpdatedEvent){

        this.id=testEntityUpdatedEvent.id;
        this.status=testEntityUpdatedEvent.status;
        this.info=testEntityUpdatedEvent.info;
    }

    @CommandHandler(commandName = "DeleteTestEntityCommand")
    public void deleteTestAggregate(DeleteTestEntityCommand command)
    {
        AggregateLifecycle.apply(new TestEntityDeletedEvent(command.id,command.status));
    }

    @EventSourcingHandler
    protected void on(TestEntityDeletedEvent testEntityDeletedEvent){

        this.id=testEntityDeletedEvent.id;
        this.status=testEntityDeletedEvent.status;
        this.info=testEntityDeletedEvent.info;
    }

    @CommandHandler
    public void compensateTestAggregate(CompensateTestEntityCommand command)
    {
        AggregateLifecycle.apply(new TestEntityCompensatedEvent(command.id,command.status));
    }

    @EventSourcingHandler
    protected void on(TestEntityCompensatedEvent testEntityCompensatedEvent){

        this.id=testEntityCompensatedEvent.id;
        this.status=testEntityCompensatedEvent.status;
    }


}
