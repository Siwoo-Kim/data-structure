package com.siwoo.datastructure.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {

    private T[] queue;
    private int front = 0;
    private int back = 0;

    public ArrayQueue(int capacity) {
        queue = (T[]) new Object[capacity];
    }

    @Override
    public int capacity() {
        return queue.length;
    }

    @Override
    public void add(T el) {
        if (size() == queue.length - 1) {
//            T[] tmp = (T[]) new Object[2 * queue.length];
//            System.arraycopy(queue, 0, tmp, 0, queue.length);
//            queue = tmp;
            int numItems = size();
            T[] tmp = (T[]) new Object[2 * queue.length];
            System.arraycopy(queue, front, tmp, 0, queue.length - front);
            System.arraycopy(queue, 0, tmp, queue.length - front, back);
            queue = tmp;
            front = 0;
            back = numItems;
        }

        queue[back] = el;
        if (back < queue.length - 1)
            back++;
        else
            back = 0;
    }

    @Override
    public T remove() {
        if (isEmpty())
            throw new NoSuchElementException();
        T el = queue[front];
        queue[front] = null;
        front++;
        if (isEmpty()) {
            front = 0;
            back = 0;
        } else if (front == queue.length) {
            front = 0;
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
        if (front <= back)
            return back - front;
        else
            return back - front + queue.length;
    }

    @Override
    public void print() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
        else {
            for (int i = front; i < queue.length; i++)
                System.out.println(queue[i]);
            for (int i = 0; i < back; i++)
                System.out.println(queue[i]);
        }

    }


}
