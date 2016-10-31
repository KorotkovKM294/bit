package ru.sbt.bit.java.lesson6.proxy;

import static ru.sbt.bit.java.lesson6.proxy.CachedInvocationHandler.cache;

/**
 * Created on 31.10.2016.
 *
 * @author Kirill M. Korotkov
 */
public class Main {
    public static void main(String[] args) {
        Calculator calculator = cache(new CalculatorImpl());
        System.out.println(calculator.calc("Alex"));
        System.out.println(calculator.calc("fdsfsd"));
        System.out.println(calculator.calc("dsdsd"));
    }
}
