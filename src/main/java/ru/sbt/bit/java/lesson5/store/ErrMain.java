package ru.sbt.bit.java.lesson5.store;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 *
 * Errors.
 */
public class ErrMain {
    static void run() {
        try {
            run();
        } finally {
            run();      // Программа зависнет
        }
    }

    static int intRun() {
        try {
            return 1;
        } finally {
            return 2; // Выполнится finally
        }
    }

    public static void main(String[] args) {
        System.out.println(intRun());
        run();
    }
}
