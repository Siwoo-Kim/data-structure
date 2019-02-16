package com.siwoo.datastructure.sort;

public class ShellSorter<E extends Comparable> extends InsertionSorter<E>{

    @Override
    public void sort(E[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int unsorted = gap; unsorted < array.length; unsorted++) {
                E el = array[unsorted];
                int pos = unsorted;
                while (pos >= gap && array[pos - gap].compareTo(el) > 0) {
                    array[pos] = array[pos - gap];
                    pos -= gap;
                }
                array[pos] = el;
            }
        }
    }
}
