package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.sort.Sorter;

public class MergeSorter<E extends Comparable> implements Sorter<E> {
    @Override
    public void sort(E[] array) {
        mergeSort(array, 0, array.length);
    }

    private void mergeSort(E[] array, int start, int end) {
        if (end - start < 2) return;
        int mid = (end + start) / 2;
        //ref: splitting phase
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        //ref: merging phase
        merge(array, start, mid, end);
    }

    private void merge(E[] array, int start, int mid, int end) {
        //ref: last index of left array = mid - 1, start index of right array = mid
        if (array[mid - 1].compareTo(array[mid]) < 0) return;
        Object[] tmp = new Object[end - start];
        int i = start;
        int j = mid;
        int pos = 0;
        while (i < mid && j < end) {
            //ref: if the value of left and right equals, then left takes priority of insertion (stable)
            tmp[pos++] = array[i].compareTo(array[j]) <= 0 ? array[i++] : array[j++];
        }
        //ref: only need to handle leftover in left,
        System.arraycopy(array, i, array, pos + start, mid - i);
        System.arraycopy(tmp, 0, array, start, pos);
    }
}
