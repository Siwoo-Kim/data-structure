package com.siwoo.datastructure.practice;

import com.siwoo.datastructure.sort.RangeSort;

public class CountSorter implements RangeSort {

    @Override
    public void sort(Integer[] element, int min, int max) {
        int[] count = new int[max - min + 1];
        for (int i = 0; i < element.length; i++) {
            count[element[i] - min]++;
        }
        int pos = 0;
        for (int i = min; i <= max; i++) {
            while (count[i - min]-- != 0) {
                element[pos++] = i;
            }
        }
    }

    @Override
    public void sort(Integer[] array) {
        sort(array, 0, array.length);
    }
}
