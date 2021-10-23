package com.example.saga.events;

public class TestEntityCompensatedEvent {

    public final String id;
    public final int status;

    public TestEntityCompensatedEvent(String id,int status)
    {
        this.id=id;
        this.status=status;
    }

}
