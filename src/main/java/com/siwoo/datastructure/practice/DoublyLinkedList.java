package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.Employee;
import com.siwoo.datastructure.list.Dequeue;

public class DoublyLinkedList<T> implements Dequeue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    @Override
    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        node.setNext(head);
        if (isEmpty())
            tail = node;
        else {
            head.setPrevious(node);
        }
        head = node;
        size++;
    }

    @Override
    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        node.setPrevious(tail);
        if (isEmpty())
            head = tail;
        else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    @Override
    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node);
            if (node.getNext() != null)
                System.out.print(", ");
            node = node.getNext();
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty())
            return null;
        Node<T> removed = head;
        if (head.getNext() == null)
            tail = null;
        else
            head.getNext().setPrevious(null);
        head = head.getNext();
        size--;
        removed.setNext(null);
        return removed.getData();
    }

    @Override
    public T removeLast() {
        if (isEmpty())
            return null;
        Node<T> removed = tail;
        if (tail.getPrevious() == null)
            head = null;
        else
            tail.getPrevious().setNext(null);
        tail = removed.getPrevious();
        size--;
        removed.setPrevious(null);
        return removed.getData();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }
}
