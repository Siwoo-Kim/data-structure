package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.queue.Queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {

    private T[] queue;
    private int front = 0;
    private int back = 0;

    public ArrayQueue(int capacity) {
        this.queue = (T[]) new Object[capacity];
    }

    @Override
    public int capacity() {
        return queue.length;
    }

    @Override
    public void add(T el) {
        if (back == queue.length) {
            T[] tmp = (T[]) new Object[2 * queue.length];
            System.arraycopy(queue, 0, tmp, 0, queue.length);
            queue = tmp;
        }
        queue[back++] = el;
    }

    @Override
    public T remove() {
        if (isEmpty())
            throw new NoSuchElementException();
        T el = queue[front];
        queue[front++] = null;
        if (isEmpty()) {
            front = 0;
            back = 0;
        }
        return el;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return back - front;
    }

    @Override
    public void print() {
        for (int i = front; i < back; i++)
            System.out.println(queue[i]);
    }
}
