package ru.sbt.bit.design.lesson11.objects;

public interface Alarm {
    AlarmState getState();
    void activate();
    void deactivate();
    void alarm();
}
