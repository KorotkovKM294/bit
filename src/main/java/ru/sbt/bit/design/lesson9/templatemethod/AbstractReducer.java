package ru.sbt.bit.design.lesson9.templatemethod;

/**
 * Шаблонный метод
 * Template method pattern
 *
 * Created on 31.10.2016.
 *
 * @author Kirill M. Korotkov
 */
public abstract class AbstractReducer {

    public int reduce(int[] arr) {
        if (arr.length == 1) return arr[0];
        int[] reduced = new int[arr.length/2 + arr.length%2];
        for (int i = 0;i < arr.length/2;i++) {
            reduced[i] = operation(arr[i*2], arr[i*2+1]);
        }
        if (arr.length % 2 == 1) {
            reduced[reduced.length-1] = arr[arr.length-1];
        }
        return reduce(reduced);
    }

    protected abstract int operation(int x, int y);
}
