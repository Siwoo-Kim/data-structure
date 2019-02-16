package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.sort.Sorter;

public class ShellSorter<E extends Comparable> implements Sorter<E> {
    @Override
    public void sort(E[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int unsorted = gap; unsorted < array.length; unsorted++) {
                E el = array[unsorted];
                int pos = unsorted;
                for ( ;pos >= gap && el.compareTo(array[pos - gap]) < 0; pos -= gap) {
                    array[pos] = array[pos - gap];
                }
                array[pos] = el;
            }
        }
    }
}
