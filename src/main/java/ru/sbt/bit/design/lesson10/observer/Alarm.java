package ru.sbt.bit.design.lesson10.observer;

public interface Alarm {
    AlarmState getState();
    void activate();
    void deactivate();
    void alarm();
}
