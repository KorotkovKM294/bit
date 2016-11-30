package ru.sbt.bit.design.lesson10.observer;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome {
    private final Collection<Light> lights = new ArrayList<>();
    private final Collection<Door> doors = new ArrayList<>();

    public SmartHome() {
    }

    public void addLight(Light light) {
        lights.add(light);
    }

    public void addDoor(Door door) {
        doors.add(door);

    }

    public void turnOffTheLights() {
        for (Light light : lights) {
            light.turnOff();
        }
    }

    public void closeDoors() {
        for (Door door : doors) {
            door.close();
        }
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

}
