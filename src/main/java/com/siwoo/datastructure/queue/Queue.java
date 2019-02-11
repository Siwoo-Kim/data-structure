package com.siwoo.datastructure.queue;

public interface Queue<T> {

    int capacity();

    void add(T el);

    T remove();

    T peek();

    boolean isEmpty();

    int size();

    void print();
}
