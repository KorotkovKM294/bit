package ru.sbt.bit.java.lesson7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 14.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class RunnableManagerImpl implements RunnableManager {

    @Override
    public void run(final Runnable callback, Runnable...runnables) {
        List<Thread> threads = new ArrayList<>();
        for (Runnable runnable : runnables) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Thread thread : threads) {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
    }
}
