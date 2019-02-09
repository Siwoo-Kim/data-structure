package com.siwoo.datastructure.stack;

/**
 * Created by sm123tt@gmail.com on 2019-02-09
 * Project : data-structure
 * Github : http://github.com/Siwoo-Kim
 */

public interface Stack<T> {
    void push(T el);

    T pop();

    T peek();

    int size();

    void print();

    boolean isEmpty();
}
