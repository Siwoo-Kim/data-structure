package com.siwoo.datastructure.list;


import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements LinkedList<E> {
    private Node<E> last;
    private Node<E> first;
    private int size = 0;

    private static class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public void linkLast(E e) {
        final Node<E> l = last;
        Node<E> newNode = new Node<>(e, last, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public void linkFirst(E e) {
        final Node<E> f = first;
        Node<E> newNode = new Node<>(e, null, first);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    @Override
    public E getLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        return last.item;
    }

    @Override
    public E getFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        return first.item;
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
        final Node<E> removed = last;
        final E element = removed.item;
        if (last.prev != null)
            last.prev.next = null;
        else
            first = null;
        last = last.prev;
        removed.prev = null;
        removed.item = null;
        return element;
    }

    @Override
    public E unlinkFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        final Node<E> removed = first;
        final E element = removed.item;
        if (first.next != null)
            first.next.prev = null;
        else
            last = null;
        first = first.next;
        removed.next = null;
        removed.item = null;
        return element;
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
