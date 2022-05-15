package com.ensa.gi4.listeners;

import org.springframework.context.ApplicationEvent;

import com.ensa.gi4.modele.Materiel;

public class MyEvent<T extends Materiel> extends ApplicationEvent {

    private final EventType eventType;

    public MyEvent(T source, EventType eventType) {
        super(source);
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }
}
