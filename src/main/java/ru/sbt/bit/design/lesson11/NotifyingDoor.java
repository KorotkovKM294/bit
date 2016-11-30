package ru.sbt.bit.design.lesson11;

import ru.sbt.bit.design.lesson11.events.DoorCloseEvent;
import ru.sbt.bit.design.lesson11.events.DoorOpenEvent;
import ru.sbt.bit.design.lesson11.events.HomeEventListener;
import ru.sbt.bit.design.lesson11.objects.Door;
import ru.sbt.bit.design.lesson11.objects.DoorType;

/**
 * Пример паттерна Decorator.
 *
 * Created on 21.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class NotifyingDoor extends ObservableObject implements Door {
    protected Door door;


    public NotifyingDoor(Door door, HomeEventListener listener) {
        this.door = door;
        setListener(listener);
    }

    @Override
    public void open() {
        door.open();
        getListener().onEvent(new DoorOpenEvent(this));
    }

    @Override
    public void close() {
        door.close();
        getListener().onEvent(new DoorCloseEvent(this));
    }

    @Override
    public boolean isOpen() {
        return door.isOpen();
    }

    @Override
    public DoorType getType() {
        return door.getType();
    }
}
