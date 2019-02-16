package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.sort.Sorter;

public class SelectionSorter<E extends Comparable> implements Sorter<E> {

    @Override
    public void sort(E[] array) {
        for (int unsorted = array.length - 1; unsorted > 0; unsorted--) {
            int largest = 0;
            for (int i = 1; i <= unsorted; i++) {
                if (array[i].compareTo(array[largest]) > 0)
                    largest = i;
            }
            swap(array, largest, unsorted);
        }
    }
}
