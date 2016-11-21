package ru.sbt.bit.design.lesson11.events;

import ru.sbt.bit.design.lesson11.objects.Light;

public class LightOnEvent extends HomeEvent {
    private final Light light;

    public LightOnEvent(Light light) {
        this.light = light;
    }
}
