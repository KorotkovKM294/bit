package ru.sbt.bit.design.lesson11;


import ru.sbt.bit.design.lesson11.events.DummyListener;
import ru.sbt.bit.design.lesson11.events.HomeEventListener;

public class ObservableObject {
    private HomeEventListener listener = new DummyListener();

    public void setListener(HomeEventListener listener) {
        this.listener = listener;
    }

    protected HomeEventListener getListener() {
        return listener;
    }
}
