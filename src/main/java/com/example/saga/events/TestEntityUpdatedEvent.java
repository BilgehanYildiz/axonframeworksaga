package com.example.saga.events;

public class TestEntityUpdatedEvent {
    public final String id;
    public final int status;
    public final String info;


    public TestEntityUpdatedEvent(String id, int status)
    {
        this.id=id;
        this.status=status;
        this.info="Test Entity updated Event";
    }

}
