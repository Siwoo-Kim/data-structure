package com.siwoo.datastructure.tree;

import java.util.Objects;

public class BinarySearchTree<E extends Comparable> implements Tree<E> {

    private Node root;

    private class Node<E extends Comparable> {
        private E el;
        private Node left;
        private Node right;
        private Node parent;

        Node(E el, Node p) {
            this.el = el;
            this.parent = p;
        }

        private void insert(E el) {
            if (Objects.equals(this.el, el))
                return;
            int compared = el.compareTo(this.el);
            //ref: value is less then the node go to left else to right.
            if (compared < 0) {
                if (left == null)
                    left = new Node(el, this);
                else
                    left.insert(el);
            } else {
                if (right == null)
                    right = new Node(el, this);
                else
                    right.insert(el);
            }
        }

        void traverseInOrder() {
            if (left != null)
                left.traverseInOrder();
            System.out.print(toString() + ", ");
            if (right != null)
                right.traverseInOrder();
        }

        Node<E> get(E el) {
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
            if (left == null)
                return this;
            else
                return left.min();
        }

        Node max() {
            if (right == null)
                return this;
            else
                return right.max();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "el=" + el +
                    '}';
        }
    }

    public E min() {
        if (root == null)
            return null;
        else
            return (E) root.min().el;
    }

    public E max() {
        if (root == null)
            return null;
        else
            return (E) root.max().el;
    }

    @Override
    public void delete(E el) {
        root = delete(el, root);
    }

    /**
     * Returns the replacement node. If the node is not the node to delete, return the original node.
     * @param el
     * @param subRoot
     * @return
     */
    private Node delete(E el, Node subRoot) {
        if (subRoot == null)
            return null;
        int c = el.compareTo(subRoot.el);
        if (c < 0) {
            subRoot.left = delete(el, subRoot.left);
        } else if (c > 0) {
            subRoot.right = delete(el, subRoot.right);
        } else {
            //ref: found the node to delete.
            final Node n = subRoot;
            //ref: Handle the case that the node has 0 or 1 child.
            if (n.left == null)
                return n.right;
            else if (n.right == null)
                return n.left;
            else {
                //ref: node to delete has 2 children.
                //ref: find the replacement node
                final Node edge =  n.left.max();
                //ref: replace the value in the subroot in the largest value from the left subtree.
                subRoot.el = edge.el;
                //ref: delete the node that has the largest value in the left subtree.
                subRoot.left = delete((E) subRoot.el, subRoot.left);
            }
        }
        //ref: the node is not the node to delete.
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
            System.out.print("EMPTY");
        else
            root.traverseInOrder();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void insert(E el) {
        if (root == null)
            //ref: root does not have parent.
            root = new Node(el, null);
        else
            root.insert(el);
    }
}
