package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.sort.Sorter;

public class InsertionSorter<E extends Comparable> implements Sorter<E> {

    @Override
    public void sort(E[] array) {
        for (int unsorted = 1; unsorted < array.length; unsorted++) {
            E el = array[unsorted];
            int pos = unsorted;
            while (pos > 0 && array[pos - 1].compareTo(el) > 0) {
                array[pos] = array[pos - 1];
                pos--;
            }
            array[pos] = el;
        }
    }
}
