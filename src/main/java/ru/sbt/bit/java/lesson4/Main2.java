package ru.sbt.bit.java.lesson4;

import java.util.Comparator;
import java.util.List;

/**
 * Created by KIDCLASS on 17.10.2016.
 */
public class Main2 {
    public static void main(String[] args) {

    }

    public static<T extends Comparable> void sort(List<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
    }
}
