package com.siwoo.datastructure.sort;

public interface Sorter<T extends Comparable> {

    void sort(T[] array);

    default void print(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (array.length - 1 != i)
                System.out.print(", ");
        }
        System.out.println();
    }
    default void swap(T[] array, int i, int j) {
        if (i == j) return;
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
