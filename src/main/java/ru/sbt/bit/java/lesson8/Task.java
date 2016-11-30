package ru.sbt.bit.java.lesson8;

import java.util.concurrent.Callable;

/**
 * Created on 21.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class Task<T> {
    private final Callable<T> callable;
    private Exception exception;
    private T result;
    private volatile boolean finished = false;

    public Task(Callable<T> callable) {
        this.callable = callable;
    }

    /**
     * call вызывается 1 раз
     * если exception выпал в call, то мы должны его сохранить и передать в след. вызове
     * если call возрващает значение, то оно возвращается в след. вызове
     * только один поток выполняет call
     * @return
     */
    public T get() throws Exception {
        if (!finished) {
            synchronized (this) {
                if (!finished) {
                    try {
                        result = callable.call();
                    } catch (Exception e) {
                        exception = e;
                    } finally {
                        finished = true;
                    }

                }
            }
        }

        if (exception != null) throw exception;
        return result;
    }
}
