package ru.sbt.bit.design.lesson10.observer;

/**
 * Created on 07.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class EntranceDoorEventListener implements EventsListener {
    private final SmartHome home;

    public EntranceDoorEventListener(SmartHome home) {
        this.home = home;
    }

    @Override
    public void onEvent(HomeEvent event) {
        if (event.getType() == HomeEventType.DOOR_CLOSED) {
            Door eventDoor = (Door) event.getEventSource();
            if (eventDoor.getType() == DoorType.ENTRANCE) {
                home.turnOffTheLights();
            }
        }
    }
}
