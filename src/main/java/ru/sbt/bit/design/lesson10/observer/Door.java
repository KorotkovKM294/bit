package ru.sbt.bit.design.lesson10.observer;

public interface Door {
    void open();
    void close();
    boolean isOpen();
    DoorType getType();
}
