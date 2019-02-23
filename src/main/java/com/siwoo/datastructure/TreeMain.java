package com.siwoo.datastructure;

import com.siwoo.datastructure.tree.BinarySearchTree;
import com.siwoo.datastructure.tree.Tree;

public class TreeMain {

    public static void main(String[] args) {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
    }
}
