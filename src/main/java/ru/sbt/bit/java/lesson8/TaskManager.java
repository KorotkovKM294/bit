package ru.sbt.bit.java.lesson8;

/**
 * Created on 21.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public interface TaskManager {

    public Context execute(Runnable... runnables);

}

