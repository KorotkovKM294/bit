package ru.sbt.bit.design.lesson10.observer;

public interface Light {
    void turnOff();
    void turnOn();
    LightState getState();
    LightLocation getLocation();
}
