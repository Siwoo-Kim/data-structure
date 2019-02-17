package com.siwoo.datastructure.sort;

public class QuickSorter<E extends Comparable> implements Sorter<E> {
    @Override
    public void sort(E[] array) {
        quickSort(array, 0, array.length);
    }

    private void quickSort(E[] array, int start, int end) {
        if (end - start < 2) return;
        //ref: after this call, pivot has corrected sorted position,
        //ref: left is smaller than pivot, right is larger than pivot.
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot);
        //ref: excluding the sorted position
        quickSort(array, pivot + 1, end);
    }

    public int partition(E[] array, int start, int end) {
        //ref: candidate for pivot is the first element
        E el = array[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && array[--j].compareTo(el) >= 0) ;
            //ref: in this point, j element is less than pivot
            if (i < j)
                array[i] = array[j];
            while (i < j && array[++i].compareTo(el) <= 0) ;
            //ref: in this point, i element is greater than pivot
            if (i < j)
                array[j] = array[i];
        }
        //ref: since we move the j first, assign el to the j index
        array[j] = el;
        return j;
    }
}
