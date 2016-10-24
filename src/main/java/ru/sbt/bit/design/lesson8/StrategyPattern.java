package ru.sbt.bit.design.lesson8;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 *
 * Шаблон "Стратегия".
 * Когда использовать Стратегию? - например, если
 * у нас есть несколько классов, которые делают похожие вещи,
 * запихнуть их в Стратегию. Или в случае, когда нужно
 * выбирать тип соритровки в зависимости от ситуации.
 *
 * Очень кстати реализует принцип D "Dependency inversion" SOLID.
 */
public class StrategyPattern {

    int[] reduce(int arr[], Operation operation) {
        int[] res = new int[arr.length / 2 + 1];
        for (int i = 0; i < arr.length; i+=2) {
            res = operation.op(arr);
        }
        if (res.length >= 2) {
            return reduce(res, operation);
        }
        return res;
    }

    interface Operation {
        public int[] op(int arr[]);
    }

}
