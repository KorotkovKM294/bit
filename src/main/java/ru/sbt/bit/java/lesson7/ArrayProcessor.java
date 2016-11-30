package ru.sbt.bit.java.lesson7;

/**
 * Created on 14.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public interface ArrayProcessor {

    int[] process(int[] original,
                  ElementStrategy strategy,
                  int threadCount);

    interface ElementStrategy {
        int process(int i);
    }

}
