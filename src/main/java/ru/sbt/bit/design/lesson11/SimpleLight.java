package ru.sbt.bit.design.lesson11;

import ru.sbt.bit.design.lesson11.events.LightOffEvent;
import ru.sbt.bit.design.lesson11.events.LightOnEvent;
import ru.sbt.bit.design.lesson11.objects.Light;
import ru.sbt.bit.design.lesson11.objects.LightLocation;
import ru.sbt.bit.design.lesson11.objects.LightState;

public class SimpleLight extends ObservableObject implements Light {
    LightState state = LightState.OFF;
    private final LightLocation location;

    public SimpleLight(LightLocation location) {
        this.location = location;
    }

    @Override
    public void turnOff() {
        state = LightState.OFF;
        getListener().onEvent(new LightOffEvent(this));
    }

    @Override
    public void turnOn() {
        state = LightState.ON;
        getListener().onEvent(new LightOnEvent(this));
    }

    @Override
    public LightState getState() {
        return state;
    }

    @Override
    public LightLocation getLocation() {
        return location;
    }
}
