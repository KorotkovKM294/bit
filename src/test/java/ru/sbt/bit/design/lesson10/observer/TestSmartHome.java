package ru.sbt.bit.design.lesson10.observer;

import org.junit.Test;

import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

public class TestSmartHome {

    @Test
    public void testTurnOffTheLights() {
        // setup
        SimpleLight testLight = createAndTurnOnTheLight();
        SmartHome home = createSmartHomeWithSingleLight(testLight);
        // exercise
        home.turnOffTheLights();
        // assert
        assertLightsAreOff(home.getLights());
    }

    @Test
    public void testTurnOffTheLightsAfterDoorsClosed() {
        // setup
        SmartHome home = new SmartHome();
        SimpleLight testLight1 = createAndTurnOnTheLight();
        SimpleLight testLight2 = createAndTurnOnTheLight();
        SimpleLight testLight3 = createAndTurnOnTheLight();
        CompositeListener listener = new CompositeListener();
        listener.addListener(new EntranceDoorEventListener(home));
        SimpleDoor testDoor1 = createAndOpenDoor(listener);
        home.addLight(testLight1);
        home.addLight(testLight2);
        home.addLight(testLight3);
        home.addDoor(testDoor1);
        // exercise
        home.closeDoors();
        // assert
        assertLightsAreOff(home.getLights());
    }

    private SimpleDoor createAndOpenDoor(EventsListener listener) {
        SimpleDoor testDoor = new SimpleDoor(DoorType.ENTRANCE, listener);
        testDoor.open();
        return testDoor;
    }

    private SmartHome createSmartHomeWithSingleLight(SimpleLight testLight) {
        SmartHome home = new SmartHome();
        home.addLight(testLight);
        return home;
    }

    private SimpleLight createAndTurnOnTheLight() {
        SimpleLight testLight = new SimpleLight(LightLocation.LIVING_ROOM);
        testLight.turnOn();
        return testLight;
    }

    private void assertLightsAreOff(Collection<Light> lights) {
        for (Light light : lights) {
            assertEquals(LightState.OFF, light.getState());
        }
    }

}
