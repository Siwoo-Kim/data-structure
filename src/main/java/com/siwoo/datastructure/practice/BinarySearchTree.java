package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.tree.Tree;

import java.util.Objects;

public class BinarySearchTree<E extends Comparable> implements Tree<E> {

    private Node root;

    private class Node<E extends Comparable> {
        private E el;
        private Node left;
        private Node right;
        private Node parent;

        public Node(E el, Node parent) {
            this.el = el;
            this.parent = parent;
        }

        void insert(E el) {
            if (Objects.equals(this.el, el))
                return;
            int c = el.compareTo(this.el);
            if (c < 0) {
                if (left == null)
                    left = new Node(el, this);
                else
                    left.insert(el);
            } else {
                if (right == null)
                    right = new Node(el,  this);
                else
                    right.insert(el);
            }
        }

        void traverInOrder() {
            if (left != null)
                left.traverInOrder();
            System.out.print(toString() + ", ");
            if (right != null)
                right.traverInOrder();
        }

        Node get(E el) {
            if (Objects.equals(this.el, el))
                return this;
            int c = el.compareTo(this.el);
            if (c < 0) {
                if (left != null)
                    return left.get(el);
            } else {
                if (right != null)
                    return right.get(el);
            }
            return null;
        }

        Node min() {
            return left == null ? this : left.min();
        }

        Node max() {
            return right == null ? this : right.max();
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
        root = delete(el, root);
    }

    private Node delete(E el, Node subRoot) {
        if (subRoot == null)
            return subRoot;
        int c = el.compareTo(subRoot.el);
        if (c < 0) {
            subRoot.left = delete(el, subRoot.left);
        } else if (c > 0) {
            subRoot.right = delete(el, subRoot.right);
        } else {
            //ref: found
            final Node n = subRoot;
            if (n.left == null)
                return n.right;
            else if (n.right == null)
                return n.left;
            else {
                //ref: both left and right child exits.
                final Node edge = n.right.min();
                subRoot.el = edge.el;
                subRoot.right = delete((E) subRoot.el, subRoot.right);
            }
        }
        return subRoot;
    }

    @Override
    public E get(E el) {
        if (root == null)
            return null;
        else {
            final Node n = root.get(el);
            return n == null ? null : (E) n.el;
        }
    }

    @Override
    public void print() {
        if (root == null)
            System.out.println("EMPTY");
        else
            root.traverInOrder();
    }

    @Override
    public void insert(E el) {
        if (root == null)
            root = new Node(el, null);
        else
            root.insert(el);
    }
}
