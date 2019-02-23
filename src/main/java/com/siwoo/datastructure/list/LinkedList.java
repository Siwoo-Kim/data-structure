package com.siwoo.datastructure.list;

public interface LinkedList<E> {

    void linkLast(E e);

    void linkFirst(E e);

    E getLast();

    E getFirst();

    boolean isEmpty();

    int size();

    E unlinkLast();

    E unlinkFirst();

    void print();

}
