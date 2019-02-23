package com.siwoo.datastructure.list;

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
        final Node<E> l = last;
        Node<E> node = new Node<>(e, l);
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
        final E el = l.item;
        last = last.prev;
        l.prev = null;
        l.item = null;
        size--;
        return el;
    }

    @Override
    public E unlinkFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void print() {
        Node<E> current = last;
        while (current != null) {
            System.out.print(current.item);
            if (current.prev != null)
                System.out.print(", ");
            current = current.prev;
        }
        System.out.println();
    }
}
