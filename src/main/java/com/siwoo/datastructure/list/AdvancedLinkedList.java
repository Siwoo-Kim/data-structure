package com.siwoo.datastructure.list;

import java.util.NoSuchElementException;

public class AdvancedLinkedList<E> implements LinkedList<E> {

    transient private Node last;
    transient private Node first;
    transient int size = 0;

    private class Node<E> {
        E el;
        private Node<E> prev;
        private Node<E> next;

        public Node(Node<E> prev, E el, Node<E> next) {
            this.el = el;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public void linkLast(E e) {
        final Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
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
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    @Override
    public E getLast() {
        return last == null ? null : (E) last.el;
    }

    @Override
    public E getFirst() {
        return first == null ? null : (E) first.el;
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
        if (last == null)
            throw new NoSuchElementException();
        final Node l = last;
        final Node prev = l.prev;
        final E el = (E) l.el;
        //ref: clean up reference
        l.el = null;
        l.prev = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return el;
    }

    @Override
    public E unlinkFirst() {
        if (first == null)
            throw new NoSuchElementException();
        final Node f = first;
        final Node next = f.next;
        final E el = (E) f.el;
        //ref: clean up reference
        f.el = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return el;
    }

    @Override
    public void print() {
        Node n = last;
        System.out.print("[");
        while (n != null) {
            System.out.print(n.el);
            if (n.prev != null)
                System.out.print(", ");
            n = n.prev;
        }
        System.out.println("]");
    }

}
