package ru.sbt.bit.java.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Cyril Korotkov on 17.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Number[] numbers = new Integer[10];
        // Какая цель была при создании generics -
        // если код компилируется, то он не должен кидать exceptions
//        List<Number> list = new ArrayList<Integer>(); // WRONG
//        numbers[0] = 1.24;                            // EXCEPTION
        List<Number> list = new ArrayList<>();
        list.add(10);
        list.add(1.0);
        Number number = list.get(0);

        List untypedList = new ArrayList<Integer>();
        List tmpList = untypedList;
        List<Number> numbers1 = tmpList;
        numbers1.add(1.42342);
        // В рантайме generics нет, только на этапе компиляции
        System.out.println(numbers1.get(0)); // 1.42342
//        Integer integer = (Integer) numbers1.get(0);  // EXCEPTION

        List<Integer> integers = Arrays.asList(10, 3);
//        print(integers);                              // NOT COMPILED
        printProducer(integers);

        addSize(integers);


        Integer max = max(Arrays.asList(10, 3, 5, 12));

        Child max2 = max(Arrays.asList(new Child("Bob"), new Child("Alex"), new Child("Ivan")));
    }

    public static void print(List<Number> numbers) {
        for (Number number : numbers) {
            System.out.println(number);
        }
    }

    public static void printProducer(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println(number);
        }
        numbers.add(null);
    }

    public static void addSize(List<? super Integer> list) {
        Integer size = list.size();
        list.add(size);
//        list.add(1.2);        // WRONG
    }


    public static <T extends Comparable<? super T>> T max(List<T> list) {
        T max = list.get(0);
        for (T t : list) {
            if (max.compareTo(t) < 0) {
                max = t;
            }
        }
        return max;
    }
}
