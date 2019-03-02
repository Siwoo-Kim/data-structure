package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.tree.Tree;
import org.omg.CORBA.PUBLIC_MEMBER;

public class BinarySearchTreePrac<E extends Comparable> implements Tree<E> {

    transient private Node root;
    transient private int size = 0;

    private class Node<E extends Comparable> {
        private final Node parent;
        private E el;
        private Node left;
        private Node right;

        public Node(E el, Node parent) {
            this.el = el;
            this.parent = parent;
        }

        public void insert(E el) {
            int c = el.compareTo(this.el);
            if (c == 0)
                return;
            else if (c < 0) {
                if (left == null) {
                    size++;
                    left = new Node(el, this);
                } else
                    left.insert(el);
            } else {
                if (right == null) {
                    size++;
                    right = new Node(el, this);
                }
                else
                    right.insert(el);
            }
        }

        void printInPreorder() {
            System.out.print(toString() + ", ");
            if (left != null)
                left.printInPreorder();
            if (right != null)
                right.printInPreorder();
        }

        void printInOrder() {
            if (left != null)
                left.printInOrder();
            System.out.print(toString() + ", ");
            if (right != null)
                right.printInOrder();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "el=" + el +
                    '}';
        }
    }

    @Override
    public void delete(E el) {

    }

    @Override
    public E get(E el) {
        return null;
    }

    @Override
    public void print() {
        if (root != null) {
            System.out.print("[");
            root.printInOrder();
            System.out.println("]");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(E el) {
        if (root == null) {
            root = new Node(el, null);
            size++;
        } else
            root.insert(el);
    }
}
