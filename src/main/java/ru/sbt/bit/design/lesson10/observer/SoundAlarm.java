package ru.sbt.bit.design.lesson10.observer;

public class SoundAlarm implements Alarm {

    private AlarmState state;

    public SoundAlarm() {
        state = AlarmState.DEACTIVATED;
    }

    @Override
    public AlarmState getState() {
        return state;
    }

    @Override
    public void activate() {
        state = AlarmState.ACTIVATED;
    }

    @Override
    public void deactivate() {
        state = AlarmState.DEACTIVATED;
    }

    @Override
    public void alarm() {
        if (state == AlarmState.ACTIVATED) {
            System.out.println("Making a loud sound!");
        }
    }

}
