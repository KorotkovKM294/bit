package ru.sbt.bit.design.lesson10.observer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created on 07.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class CompositeListener implements EventsListener {
    private final Collection<EventsListener> eventsListener;

    public CompositeListener() {
        eventsListener = new ArrayList<>();
    }

    public CompositeListener(Collection<EventsListener> eventsListener) {
        this.eventsListener = eventsListener;
    }

    @Override
    public void onEvent(HomeEvent event) {
        for (EventsListener listener : eventsListener) {
            listener.onEvent(event);
        }
    }

    public void addListener(EventsListener listener) {
        eventsListener.add(listener);
    }
}
