package ru.sbt.bit.java.lesson7;

import java.util.List;

/**
 * Created on 14.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class ThreadPool {
    private List<Runnable> runnables;

    public void start(int count) {
        synchronized (this) {
            while (true) {
                if (runnables.isEmpty()) {
                    doWait();
                }
                Runnable runnable = runnables.remove(count);
                runnable.run();
                notify();
            }
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this) {
            while (true) {
                if (runnables.size() > 4) {
                    doWait();
                }
                runnables.add(runnable);
                notify();
            }
        }
    }

    private void doWait() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
