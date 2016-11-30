package ru.sbt.bit.design.lesson11.events;

import ru.sbt.bit.design.lesson11.objects.Light;

public class LightOffEvent extends HomeEvent {
    private final Light light;

    public LightOffEvent(Light light) {
        this.light = light;
    }
}
