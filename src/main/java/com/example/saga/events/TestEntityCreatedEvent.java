package com.example.saga.events;

public class TestEntityCreatedEvent {
    public final String id;
    public final String name;
    public final String info;

    public TestEntityCreatedEvent(String id,String name)
    {
        this.id=id;
        this.name=name;
        this.info="Test Entity created Event";
    }

}
