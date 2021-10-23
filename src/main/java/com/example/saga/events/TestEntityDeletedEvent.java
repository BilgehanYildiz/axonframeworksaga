package com.example.saga.events;

public class TestEntityDeletedEvent {
    public final String id;
    public final int status;
    public final String info;


    public TestEntityDeletedEvent(String id, int status)
    {
        this.id=id;
        this.status=status;
        this.info="Test Entity updated Event";
    }

}
