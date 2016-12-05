package ru.sbt.bit.design.lesson13;

/**
 * Created by Cyril Korotkov on 30.11.2016.
 */
public interface Command {

    void execute();

    void undo();

}
