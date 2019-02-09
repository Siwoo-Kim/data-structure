package com.siwoo.datastructure.list;

public class DoublyLinkedList<T> implements Dequeue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void addFirst(T data) {
        Node node = new Node(data);
        node.setNext(head);
        if (head == null)
            tail = node;
        else
            head.setPrevious(node);

        head = node;
        size++;
    }

    @Override
    public void addLast(T data) {
        Node node = new Node(data);
        tail.setNext(node);
        if (tail == null)
            head = node;
        else {
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("[EMPTY]");
            return;
        }
        Node node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node);
            if (node.getNext() != null)
                sb.append(", ");
            node = node.getNext();
        }
        sb.append("]");
        System.out.println(sb);
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
        head = removed.getNext();
        removed.setNext(null);
        size--;
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
        tail = tail.getPrevious();
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
