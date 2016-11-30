package ru.sbt.bit.java.lesson6.proxy;

/**
 * Created on 31.10.2016.
 *
 * @author Kirill M. Korotkov
 */
public class CalculatorImpl implements Calculator {
    @Override
    public int calc(String b) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 10 * b.length();
    }
}
