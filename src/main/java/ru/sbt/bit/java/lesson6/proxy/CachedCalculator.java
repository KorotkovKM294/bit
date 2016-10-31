package ru.sbt.bit.java.lesson6.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 31.10.2016.
 *
 * @author Kirill M. Korotkov
 */
public class CachedCalculator implements Calculator {
    private final Map<String, Integer> cache = new HashMap<>();
    private final Calculator calculator;

    public CachedCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public static Calculator cache(Calculator calculator) {
        return new CachedCalculator(calculator);
    }

    @Override
    public int calc(String b) {
        if (cache.containsKey(b)) return cache.get(b);

        int result = calculator.calc(b);

        cache.put(b, result);
        return result;
    }
}
