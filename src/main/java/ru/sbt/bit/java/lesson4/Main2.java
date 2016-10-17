package ru.sbt.bit.java.lesson4;

import ru.sbt.bit.java.lesson4.container.Container;
import ru.sbt.bit.java.lesson4.container.FixedSizeContainer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * PECS
 * producer extends consumer super
 *
 * Created by Cyril Korotkov on 17.10.2016.
 */
public class Main2 {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Child("Bob"), new Child("Alex"), new Child("Ivan"));
        sort(list);

        Comparator<Object> comparator = new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        Person max = max(list, comparator);


        Container<String> c1 = new FixedSizeContainer(10);
        c1.add("John");
        Container<String> c2 = new FixedSizeContainer<>(5);
        c2.add("Alex");
        c1.addInto(c2);
        System.out.println();
    }

    // Самостоятельно: Надо сделать метод sort
    public static<T extends Comparable> void sort(List<T> list) {
         list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
    }

    // Самостоятельно: Надо сделать max (см Main) c Comparator
    public static <T> T max(List<T> list, Comparator<? super T> comparator) {
        T max = list.get(0);
        for (T t : list) {
            if (comparator.compare(t, max) < 0) {
                max = t;
            }
        }
        return max;
    }
}
