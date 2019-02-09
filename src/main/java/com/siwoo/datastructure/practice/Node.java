package com.siwoo.datastructure.practice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> previous;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data == null ? "null" : data.toString();
    }
}
