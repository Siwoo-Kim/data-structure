package com.siwoo.datastructure.tree;

public interface Tree<E extends Comparable> {
    void delete(E el);

    E get(E el);

    void print();

    void insert(E el);
}
