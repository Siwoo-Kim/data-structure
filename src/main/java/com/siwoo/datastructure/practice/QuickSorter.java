package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.sort.Sorter;

public class QuickSorter<E extends Comparable> implements Sorter<E> {
    @Override
    public void sort(E[] array) {
        quickSort(array, 0, array.length);
    }

    private void quickSort(E[] array, int start, int end) {
        if (end - start < 2) return;
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot);
        quickSort(array, pivot + 1, end);
    }

    private int partition(E[] array, int start, int end) {
        E el = array[start];
        int i = start;
        int j = end;
        while (i < j) {
            //ref: last part first.
            while (i < j && array[--j].compareTo(el) > 0) ;
            if (i < j)
                array[i] = array[j];
            while (i < j && array[++i].compareTo(el) < 0) ;
            if (i < j)
                array[j] = array[i];
        }
        array[j] = el;
        return j;
    }
}
