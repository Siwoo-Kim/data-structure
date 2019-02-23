package com.siwoo.datastructure.sort;

import java.util.LinkedList;

public class RadixSorter<T> {

//    public static void radixSort(int[] input, int radix, int width) {
//        for (int i = 0; i < width; i++)
//            radixSingleSort(input, i, radix);
//    }
//
//    public static void radixSingleSort(int[] input, int position, int radix) {
//        int numItems = input.length;
//        int[] count = new int[radix];
//        for (int value: input) {
//            count[getDigit(position, value, radix)]++;
//        }
//        //ref: Adjust the count array.
//        for (int j = 1; j < radix; j++) {
//            count[j] += count[j - 1];
//        }
//        int[] tmp = new int[numItems];
//        for (int i = numItems - 1; i >= 0; i--) {
//            tmp[--count[getDigit(position, input[i], radix)]] = input[i];
//
//        }
//    }
//
//    private static int getDigit(int position, int value, int radix) {
//        return value / (int) Math.pow(10, position) % radix;
//    }

}
