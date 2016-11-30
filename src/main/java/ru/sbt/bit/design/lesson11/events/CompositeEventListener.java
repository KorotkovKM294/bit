package ru.sbt.bit.design.lesson11.events;

import java.util.ArrayList;
import java.util.Collection;

public class CompositeEventListener implements HomeEventListener {
    final Collection<HomeEventListener> listeners;

    public CompositeEventListener() {
        listeners = new ArrayList<>();
    }

    public CompositeEventListener addListener(HomeEventListener homeEventListener) {
        listeners.add(homeEventListener);
        return this;
    }

    @Override
    public void onEvent(HomeEvent event) {
        for (HomeEventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}
