package com.siwoo.datastructure.tree;

import java.util.Objects;

public class BinarySearchTree<E extends Comparable> implements Tree<E> {

    private Node<E> root;

    private class Node<E extends Comparable> {
        private E el;
        private Node<E> left;
        private Node<E> right;
        private Node<E> parent;

        public Node(E el) {
            this.el = el;
        }

        public void insert(E el) {
            if (Objects.equals(this.el, el))
                return;
            if (el.compareTo(this.el) < 0)
                if (left == null)
                    left = new Node<>(el);
                else
                    left.insert(el);
            else
                if (right == null)
                    right = new Node<>(el);
                else
                    right.insert(el);
        }
    }

    @Override
    public void insert(E el) {
        if (root == null)
            root = new Node<>(el);
        else
            root.insert(el);
    }

}
