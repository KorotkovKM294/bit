package ru.sbt.bit.java.lesson8;

/**
 * Created on 21.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class RunnableTask implements Runnable {
    private final Runnable runnable;
    private final Context context;

    public RunnableTask(Runnable runnable, Context context) {
        this.runnable = runnable;
        this.context = context;
    }

    @Override
    public void run() {
        runnable.run();
    }
}
