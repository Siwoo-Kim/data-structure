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
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
    }

    private void merge(E[] array, int start, int mid, int end) {
        if (array[mid - 1].compareTo(array[mid]) <= 0) return;
        Object[] tmp = new Object[end - start];
        int pos = 0;
        int i = start;
        int j = mid;
        while (i < mid && j < end)
            tmp[pos++] = array[i].compareTo(array[j]) <= 0 ? array[i++] : array[j++];
        System.arraycopy(array, i, array, start + pos, mid - i);
        System.arraycopy(tmp, 0, array, start, pos);
    }
}
