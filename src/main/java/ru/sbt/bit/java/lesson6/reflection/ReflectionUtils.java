package ru.sbt.bit.java.lesson6.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 31.10.2016.
 *
 * @author Kirill M. Korotkov
 */
public class ReflectionUtils {

    public static void printMethodInfo(Object o) {
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            clazz = clazz.getSuperclass();
        }
    }

    /**
     * Сделать метод, возвращающий все поля объекта
     */
    public static List<Field> getFields(Object o) {
        List<Field> allFields = new ArrayList<>();
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            Collections.addAll(allFields, clazz.getDeclaredFields());
            clazz = clazz.getSuperclass();
        }
        return allFields;
    }

    public static List<Object> getFieldValues(Object o) {
        List<Object> allValues = new ArrayList<>();
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(o);
                    allValues.add(value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("impossible", e);
                }
            }
            clazz = clazz.getSuperclass();
        }
        return allValues;
    }

    public static List<Object> getGetterValues(Object o) {
        List<Object> allValues = new ArrayList<>();
        Class<?> clazz = o.getClass();
        for (Method method : clazz.getMethods()) {
            if (method.getName().startsWith("get")
                    && method.getParameterCount() == 0
                    && method.getReturnType() != void.class) {
                try {
                    method.setAccessible(true);
                    Object value = method.invoke(o);
                    allValues.add(value);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException("impossible", e);
                }
            }
        }
        return allValues;
    }

    public static void main(String[] args) {
        for (Field field : getFields(Person.class)) {
            System.out.println(field);
        }

        Person alex = new Person("Alex", 16, true);
        for (Object o : getGetterValues(Person.class)) {
            System.out.println(o);
        }
    }
}
