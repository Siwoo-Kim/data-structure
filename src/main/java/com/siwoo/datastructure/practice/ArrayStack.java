package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.stack.Stack;

import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {

    private T[] stack;
    private int top;

    public ArrayStack(int capacity) {
        this.stack = (T[]) new Object[capacity];
    }

    @Override
    public void push(T el) {
        if (top == stack.length) {
            T[] newStack = (T[]) new Object[2 * stack.length];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[top++] = el;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        T el = stack[--top];
        stack[top] = null;
        return el;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return stack[top - 1];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public void print() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
