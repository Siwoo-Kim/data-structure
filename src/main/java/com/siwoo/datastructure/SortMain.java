package com.siwoo.datastructure;

import com.siwoo.datastructure.practice.BubbleSort;

import java.util.Arrays;

public class SortMain {

    public static void main(String[] args) {
        int[] array = { 20, 35, -15, 7, 55, 1, -22 };
        BubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
