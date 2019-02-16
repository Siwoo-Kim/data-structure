package com.siwoo.datastructure;

import com.siwoo.datastructure.sort.*;


public class SorterMain {

    public static void main(String[] args) {
        Integer[] array = { 20, 35, -15, 7, 55, 1, -22 };
//        Sorter<Integer> sorter = new BubbleSorter<>();
//        Sorter<Integer> sorter = new SelectionSorter<>();
        Sorter<Integer> sorter = new InsertionSorter<>();
        sorter = new ShellSorter<>();
        sorter.sort(array);
        sorter.print(array);
    }
}
