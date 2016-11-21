package ru.sbt.bit.design.lesson11;

import ru.sbt.bit.design.lesson11.events.DoorCloseEvent;
import ru.sbt.bit.design.lesson11.events.HomeEvent;
import ru.sbt.bit.design.lesson11.events.HomeEventListener;
import ru.sbt.bit.design.lesson11.objects.DoorType;

public class MyHomeEventsListener implements HomeEventListener {

    private final SmartHome smartHome;

    public MyHomeEventsListener(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void onEvent(HomeEvent event) {
        if (event instanceof DoorCloseEvent) {
            DoorCloseEvent doorCloseEvent = (DoorCloseEvent) event;
            if (doorCloseEvent.getDoor().getType() == DoorType.ENTRANCE) {
                smartHome.turnOffTheLights();
            }
        }
    }
}
