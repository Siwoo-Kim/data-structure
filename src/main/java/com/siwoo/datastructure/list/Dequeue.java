package com.siwoo.datastructure.list;

public interface Dequeue<T> {

    void addFirst(T data);

    void addLast(T data);

    void print();

    T removeFirst();

    T removeLast();

    boolean isEmpty();

    int size();
}
