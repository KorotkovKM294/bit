package ru.sbt.bit.design.lesson10.observer;

/**
 * Created on 07.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class HomeEvent {
    private final Object eventSource;
    private final HomeEventType type;

    public HomeEvent(Object eventSource, HomeEventType type) {
        this.eventSource = eventSource;
        this.type = type;
    }

    public Object getEventSource() {
        return eventSource;
    }

    public HomeEventType getType() {
        return type;
    }
}
