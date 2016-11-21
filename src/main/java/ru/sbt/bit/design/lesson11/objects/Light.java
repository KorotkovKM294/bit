package ru.sbt.bit.design.lesson11.objects;

public interface Light {
    void turnOff();
    void turnOn();
    LightState getState();
    LightLocation getLocation();
}
