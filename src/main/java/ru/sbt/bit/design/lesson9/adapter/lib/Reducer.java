package ru.sbt.bit.design.lesson9.adapter.lib;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 */
public class Reducer {

    int[] reduce(int arr[], Operation operation) {
        int[] res = new int[arr.length / 2 + 1];
        for (int i = 0; i < arr.length; i+=2) {
            res[i] = operation.op(arr[i], arr[i+1]);
        }
        if (res.length >= 2) {
            return reduce(res, operation);
        }
        return res;
    }

}
