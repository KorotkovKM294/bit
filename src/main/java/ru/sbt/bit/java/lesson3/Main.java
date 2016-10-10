package ru.sbt.bit.java.lesson3;

import java.util.*;

/**
 * Created by Cyril Korotkov on 10.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<String>();
        List<String> linkedList = new LinkedList<String>();

        Map<Person, Integer> hashMap = new HashMap<Person, Integer>();
        hashMap.put(new Person("Alex"), 20);
        hashMap.put(new Person("ALEX"), 80);
        System.out.println(hashMap.size());
        System.out.println(hashMap.get(new Person("Alex")));

        Map<Person, Integer> treeMap = new TreeMap<Person, Integer>(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.compareTo(o2);
            }
        });
        treeMap.put(new Person("Alex"), 20);
        treeMap.put(new Person("ALEX"), 50);
        System.out.println(treeMap.size());
        System.out.println(treeMap.get(new Person("Alex")));

        Set<Person> hashSet = new HashSet<Person>();
        hashSet.add(new Person("Alex"));
        hashSet.add(new Person("Alex"));
        System.out.println(hashSet.size());

    }
}
