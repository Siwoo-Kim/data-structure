package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.list.LinkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> last;
    private int size = 0;

    private static class Node<E> {
        private E item;
        private Node<E> prev;

        public Node(E item, Node<E> prev) {
            this.item = item;
            this.prev = prev;
        }
    }

    @Override
    public void linkLast(E e) {
        Node<E> node = new Node<>(e, last);
        last = node;
        size++;
    }

    @Override
    public void linkFirst(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E getLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        return last.item;
    }

    @Override
    public E getFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E unlinkLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        final Node<E> l = last;
        final E item = l.item;
        last = last.prev;
        size--;
        l.prev = null;
        l.item = null;
        return item;
    }

    @Override
    public E unlinkFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void print() {
        Node<E> c = last;
        while (c != null) {
            System.out.print(c.item);
            if (c.prev != null)
                System.out.print(", ");
            c = c.prev;
        }
        System.out.println();
    }
}
