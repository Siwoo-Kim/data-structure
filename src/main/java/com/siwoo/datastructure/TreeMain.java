package com.siwoo.datastructure;

import com.siwoo.datastructure.practice.BinarySearchTreePrac;
import com.siwoo.datastructure.tree.Tree;

import static org.junit.Assert.assertEquals;

public class TreeMain {

    public static void main(String[] args) {
        Tree<Integer> tree = new BinarySearchTreePrac<>();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
        tree.insert(17);
        assertEquals(tree.size(), 10);
        tree.print();
//
//        tree.print();
//        System.out.println();
//        Assert.assertEquals(tree.get(27), new Integer(27));
//        Assert.assertEquals(tree.get(17), new Integer(17));
//        Assert.assertNull(tree.get(887));
//
////        System.out.println(((BinarySearchTree<Integer>) tree).min());
////        System.out.println(((BinarySearchTree<Integer>) tree).max());
//        tree.delete(15);
//        tree.print();
//        System.out.println();
//        tree.delete(27);
//        tree.print();
//        System.out.println();
//        tree.delete(25);
//        tree.print();
//        System.out.println();
//        tree.delete(8888);
//        tree.print();
//        System.out.println();
    }
}
