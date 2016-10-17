package ru.sbt.bit.java.lesson4;

import ru.sbt.bit.java.lesson4.container.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Cyril Korotkov on 17.10.2016.
 */
public class Simple {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(10);
        list.add(10.32d);
        list.add("I am Long");
//        Integer o = (Integer) list.get(2);    // EXCEPTION

        Map<String, Long> map = new TreeMap<String, Long>();
        map.put("10", 100L);
        Map<String, List<Map<Long, Map<Integer, String>>>> hardMap = new TreeMap<>();

        Container<Double> container = new FixedSizeContainer<>(20);
        container.add(10.3);
        container.add(1.3);
        container.add(123.321);
        Double aDouble = container.get(1);

        GenericPair<String, Integer> p1 = new GenericPair<>("e", 1);
        GenericPair<Double, Long> p2 = new GenericPair<>(2.d, 3L);
        Double first1 = p2.getFirst();
    }

    public static Pair calc() {
        return new Pair(43, "Hello");
    }

    public static LongDoublePair calcLongDouble() {
        return new LongDoublePair(43L, 43.4);
    }
}