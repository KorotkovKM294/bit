package ru.sbt.bit.design.lesson9.templatemethod;

/**
 * Created on 31.10.2016.
 *
 * @author Kirill M. Korotkov
 */
public class MaxReducer extends AbstractReducer {

    @Override
    protected int operation(int x, int y) {
        return Math.max(x, y);
    }
}
