package com.siwoo.datastructure.practice;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private int size = 0;

    public void add(T data) {
        Node<T> node = new Node<>(data);
        node.setNext(head);
        head = node;
        size++;
    }

    public T remove() {
        if (isEmpty())
            return null;
        Node<T> removed = head;
        head = removed.getNext();
        size--;
        removed.setNext(null);
        return removed.getData();
    }

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
