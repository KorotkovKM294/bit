package ru.sbt.bit.design.lesson10.observer;

/**
 * Created on 07.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class AlarmActivationOnDoorsClose implements EventsListener {
    private final Alarm alarm;

    public AlarmActivationOnDoorsClose(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void onEvent(HomeEvent event) {
        alarm.activate();
    }
}
