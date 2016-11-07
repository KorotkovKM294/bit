package ru.sbt.bit.design.lesson10.observer;

public class SimpleDoor implements Door {
    private boolean isOpen = false;
    private final DoorType doorType;
    private final EventsListener eventsListener;

    public SimpleDoor(DoorType doorType, EventsListener eventsListener) {
        this.doorType = doorType;
        this.eventsListener = eventsListener;
    }

    @Override
    public void open() {
        isOpen = true;
    }

    @Override
    public void close() {
        isOpen = false;
        HomeEvent event = new HomeEvent(this, HomeEventType.DOOR_CLOSED);
        eventsListener.onEvent(event);
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public DoorType getType() {
        return doorType;
    }
}
