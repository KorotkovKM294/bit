package ru.sbt.bit.java.lesson5.store;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 */
public class Main2 {
    private final Store store;

    public Main2(Store store) {
        this.store = store;
    }

    public void run() {
        store.save("Hello World");
    }

    public static void main(String[] args) {
        new Main2(new FileStore()).run();
    }
}
