package com.siwoo.datastructure.search.searcher;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Searcher<E> {

    private static final String GETTER_PREFIX = "get";

    abstract public int search(E[] elements, E element);

    abstract public int search(E[] elements, String attribute, Object value);

    protected Object invoke(E element, String attribute) {
        Class clazz = element.getClass();
        try {
            Method m = clazz.getMethod(getMethodName(attribute));
            return m.invoke(element);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            return null;
        }
    }

    String getMethodName(String attribute) {
        return GETTER_PREFIX + Character.toUpperCase(attribute.charAt(0)) + attribute.substring(1);
    };
}
