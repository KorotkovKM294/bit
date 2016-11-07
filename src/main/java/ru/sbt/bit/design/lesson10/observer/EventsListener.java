package ru.sbt.bit.design.lesson10.observer;

/**
 * Created on 07.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public interface EventsListener {

    public void onEvent(HomeEvent event);
}
