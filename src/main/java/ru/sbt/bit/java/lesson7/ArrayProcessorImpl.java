package ru.sbt.bit.java.lesson7;

/**
 * Created on 14.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class ArrayProcessorImpl implements ArrayProcessor {
    int index = 0;
    int max = 10;

    @Override
    public int[] process(int[] original,
                         ElementStrategy strategy,
                         int threadCount) {
        final int length = original.length;
        max = length / threadCount;
        final int counter = length % threadCount == 0 ? max : max + length % threadCount;
        int[] result = new int[length];
        Runnable runnable = new Runnable() {
            @Override
            public synchronized void run() {
                if (max < length) {
                    for (int i = index; i < max; i++) {
                        result[i] = strategy.process(original[i]);
                    }
                    index = max;
                    max += counter;
                }
            }
        };
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("interrupted", e);
            }
        }

        return result;
    }
}
