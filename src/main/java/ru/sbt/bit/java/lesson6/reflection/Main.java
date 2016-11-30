package ru.sbt.bit.java.lesson6.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created on 31.10.2016.
 *
 * @author Kirill M. Korotkov
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Object.class.getSuperclass());

        try {
            Object o = Object.class.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {

        }

    }

    private void setObjectName(Object o, String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = o.getClass();
        Method method = clazz.getMethod("setName", String.class);
        method.invoke(o, name);
    }
}
