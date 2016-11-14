package ru.sbt.bit.java.lesson7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 14.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class Producers {
    private final List<String> strings = new ArrayList<>();

    public void produce() {
        while (true) {
            strings.add("idem " + System.currentTimeMillis());
        }
    }

    public void consume() {
        while (true) {
            if (!strings.isEmpty()) {
                String remove = strings.remove(0);
                System.out.println(remove);
            }
        }
    }

    public static void main(String[] args) {

    }
}
