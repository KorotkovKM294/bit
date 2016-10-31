package ru.sbt.bit.java.lesson6.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 31.10.2016.
 *
 * @author Kirill M. Korotkov
 */
public class CachedInvocationHandler implements InvocationHandler {
    private final Map<List<Object>, Object> cache = new HashMap<>();
    private final Object delegate;

    public CachedInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    public static<T> T cache(T o) {
        return (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                o.getClass().getInterfaces(), new CachedInvocationHandler(o));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Object> key = key(method, args);
        if (cache.containsKey(key)) return cache.get(key);

        Object result = method.invoke(delegate, args);

        cache.put(key, result);
        return null;
    }

    private List<Object> key(Method method, Object[] args) {
        List<Object> key = new ArrayList<>();
        key.add(method);
        return key;
    }
}
