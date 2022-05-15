package com.ensa.gi4.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.ensa.gi4.modele.Materiel;

@Component
public class ApplicationEventListener<T extends Materiel> implements ApplicationListener<MyEvent<T>> {
    @Override
    public void onApplicationEvent(MyEvent<T> event) {
        System.out.println( event.getSource() + " " + event.getEventType() + " successfully ! ");
    }
}
