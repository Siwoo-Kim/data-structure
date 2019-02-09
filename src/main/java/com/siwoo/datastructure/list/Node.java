package com.siwoo.datastructure.list;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Node<T> {

    private Node next;
    private Node previous;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data == null ? "null" : data.toString();
    }
}
