package ru.sbt.bit.design.lesson11;

import ru.sbt.bit.design.lesson11.events.DoorCloseEvent;
import ru.sbt.bit.design.lesson11.events.DoorOpenEvent;
import ru.sbt.bit.design.lesson11.objects.Door;
import ru.sbt.bit.design.lesson11.objects.DoorType;

public class SimpleDoor extends ObservableObject implements Door {
    private final DoorType doorType;
    private boolean isOpen = false;

    public SimpleDoor(DoorType doorType) {
        this.doorType = doorType;
    }

    @Override
    public void open() {
        isOpen = true;
    }

    @Override
    public void close() {
        isOpen = false;
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
