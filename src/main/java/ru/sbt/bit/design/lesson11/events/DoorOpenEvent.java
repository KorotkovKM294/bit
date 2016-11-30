package ru.sbt.bit.design.lesson11.events;

import ru.sbt.bit.design.lesson11.objects.Door;

public class DoorOpenEvent extends HomeEvent {

    private Door door;

    public DoorOpenEvent(Door door) {
        this.door = door;
    }

    public Door getDoor() {
        return door;
    }
}
