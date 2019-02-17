package com.siwoo.datastructure.sort;

public class CountSorter implements RangeSort {

    @Override
    public void sort(Integer[] element, int min, int max) {
        int[] count = new int[(max - min) + 1];
        for (int i = 0; i < element.length; i++) {
            //ref: map to the index
            count[element[i] - min]++;
        }
        int pos = 0;
        for (int i = min; i <= max; i++) {
            //ref: repeat until the count is 0
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
