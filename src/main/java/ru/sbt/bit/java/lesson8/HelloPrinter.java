package ru.sbt.bit.java.lesson8;

/**
 * С таким примером возможно такое, что
 * hello выведет меньше 1 раза.
 *
 * Created on 21.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class HelloPrinter {
    private boolean hello = true;

    public synchronized void greet() {
        if (hello) {
            System.out.println("hello");
        }
        hello = false;
    }
}
