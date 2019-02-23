package com.siwoo.datastructure.sort;

/**
 * Created by sm123tt@gmail.com on 2019-02-17
 * Project : data-structure
 * Github : http://github.com/Siwoo-Kim
 */

public class SortContext<E extends Comparable> {
    private Sorter<E> sorter;

    public void setSorter(Sorter<E> sorter) {
        this.sorter = sorter;
    }

    public void doSort(E[] element) {
        this.sorter.sort(element);
    }

    public void doSortInRange(E[] element, int min, int max) {
        if (sorter instanceof RangeSort) {
            ((RangeSort) sorter).sort((Integer[]) element, min, max);
            return;
        }
        throw new UnsupportedOperationException();
    }

    public void print(E[] array) {
        this.sorter.print(array);
    }
}
