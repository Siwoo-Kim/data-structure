package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.list.Dequeue;
import sun.dc.pr.PRError;

import java.util.Deque;

public class DoublyLinkedList<T> implements Dequeue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void addFirst(T data) {
        Node node = new Node(data);
        if (isEmpty())
            tail = node;
        else {
            node.setNext(head);
            head.setPrevious(node);
        }
        head = node;
        size++;
    }

    @Override
    public void addLast(T data) {
        Node node = new Node(data);
        if (isEmpty())
            head = node;
        else {
            node.setPrevious(tail);
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    @Override
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current + " ");
            current = current.getNext();
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
        removed.setPrevious(null);
        size--;
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
