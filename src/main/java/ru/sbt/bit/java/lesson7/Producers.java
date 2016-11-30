package ru.sbt.bit.java.lesson7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 14.11.2016.
 *
 * Стандартный шаблон producer-consumer
 *
 * @author Kirill M. Korotkov
 */
public class Producers {
    private final List<String> strings = new ArrayList<>();

    public void produce() {
        synchronized (this) {
            while (true) {
                if (strings.size() > 10_000) {
                    doWait();
                }
                strings.add("idem " + System.currentTimeMillis());
                notify();
            }
        }
    }

    public void consume() {
        synchronized (this) {
            while (true) {
                if (strings.isEmpty()) {
                    doWait();
                }
                String remove = strings.remove(0);
                notify();
                System.out.println(remove);
            }
        }
    }

    private void doWait() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
