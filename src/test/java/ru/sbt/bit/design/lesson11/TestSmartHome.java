package ru.sbt.bit.design.lesson11;

import org.junit.Test;
import ru.sbt.bit.design.lesson11.objects.DoorType;
import ru.sbt.bit.design.lesson11.objects.Light;
import ru.sbt.bit.design.lesson11.objects.LightLocation;
import ru.sbt.bit.design.lesson11.objects.LightState;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

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
    public void testTurnsOffTheLightsWhenEntranceDoorIsClosed() {
        // setup
        SmartHome home = new SmartHome();
        home.addLight(createAndTurnOnTheLight());
        home.addLight(createAndTurnOnTheLight());
        SimpleDoor entranceDoor = new SimpleDoor(DoorType.ENTRANCE);
        NotifyingDoor door = new NotifyingDoor(entranceDoor, new MyHomeEventsListener(home));
        home.addDoor(door);
        // exercise
        door.close();
        // assert
        assertLightsAreOff(home.getLights());
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
