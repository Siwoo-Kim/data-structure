package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.sort.Sorter;

public class BubbleSorter<E extends Comparable> implements Sorter<E> {

    @Override
    public void sort(E[] array) {
        for (int unsorted = array.length - 1; unsorted > 0; unsorted--) {
            for (int i = 0; i < unsorted; i++) {
                if (array[i].compareTo(array[i + 1]) > 0)
                    swap(array, i, i + 1);
            }
        }
    }
}
