package com.siwoo.datastructure.list;

import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private transient Node<E> last;
    private transient int size = 0;

    private static class Node<E> {
        private E el;
        private Node prev;

        public Node(E el, Node prev) {
            this.el = el;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "el=" + el +
                    '}';
        }
    }


    @Override
    public void linkLast(E e) {
        final Node l = last;
        final Node newNode = new Node(e, l);
        last = newNode;
        size++;
    }

    @Override
    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.el;
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
        final E item = (E) l.el;
        final Node<E> prev = last.prev;
        l.prev = null;
        l.el = null;
        last = prev;
        size--;
        return item;
    }

    @Override
    public E unlinkFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void linkFirst(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E getFirst() {
        throw new UnsupportedOperationException();
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
