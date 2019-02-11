package com.siwoo.datastructure.practice;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        for (int unsorted = array.length - 1; unsorted > 0; unsorted--) {
            for (int i = 0; i < unsorted; i++) {
                if (array[i] > array[i + 1])
                    swap(array, i, i + 1);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) return;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
