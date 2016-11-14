package ru.sbt.bit.java.lesson7;

import java.util.ArrayList;
import java.util.List;

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
        final int batchSize = length / threadCount;
        max = length % threadCount == 0 ? batchSize : batchSize + length % threadCount;
        int[] result = new int[length];
        Runnable runnable = new Runnable() {
            @Override
            public synchronized void run() {
                if (max <= length) {
                    for (int i = index; i < max; i++) {
                        result[i] = strategy.process(original[i]);
                    }
                    index = max;
                    max += batchSize;
                }
            }
        };
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();

        }
        for (Thread forJoin : threads) {
            try {
                forJoin.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("interrupted", e);
            }
        }
        index = 0;
        return result;
    }

    // Это часть решения, которое написал он (лень было переписывать все)
    private static class Worker implements Runnable {
        private final int[] original;
        private final int[] result;
        private final int from;
        private final int to;
        private final ElementStrategy strategy;

        public Worker(int[] original, int[] result, int from, int to, ElementStrategy strategy) {
            this.original = original;
            this.result = result;
            this.from = from;
            this.to = to;
            this.strategy = strategy;
        }

        @Override
        public void run() {
            for (int i = from; i < to; i++) {
                result[i] = strategy.process(original[i]);
            }
        }
    }

}
