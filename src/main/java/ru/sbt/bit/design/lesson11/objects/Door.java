package ru.sbt.bit.design.lesson11.objects;

public interface Door {
    void open();
    void close();
    boolean isOpen();
    DoorType getType();
}
