package com.siwoo.datastructure.list;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    public void add(T t) {
        Node<T> node = new Node<>(t);
        node.setNext(head);
        head = node;
        size++;
    }

    public T remove() {
        if (isEmpty())
            return null;
        Node<T> removed = head;
        head = head.getNext();
        removed.setNext(null);
        size--;
        return removed.getData();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<T> current = head;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current);
            if (current.getNext() != null)
                System.out.print(", ");
            current = current.getNext();
        }
        System.out.println(" ]");
    }

}
