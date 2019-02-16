package com.siwoo.datastructure.sort;

public class InsertionSorter<E extends Comparable> implements Sorter<E> {
    @Override
    public void sort(E[] array) {
//        for (int unsorted = 1; unsorted < array.length; unsorted++) {
//            E el = array[unsorted];
//            int pos = unsorted;
//            for( ;pos > 0 && el.compareTo(array[pos - 1]) < 0; pos--) {
//                array[pos] = array[pos - 1];
//            }
//            array[pos] = el;
//        }
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
