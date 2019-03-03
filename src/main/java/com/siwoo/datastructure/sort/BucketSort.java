package com.siwoo.datastructure.sort;

import java.util.*;

public class BucketSort {

    public static void main(String[] args) {
        int[] array = {54, 46, 83, 66, 95, 92, 43};
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bucketSort(int[] array) {
        //ref: make assumption that all values in array has two digits.
        List<Integer>[] buckets = new List[10];
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayList<>();

        //ref: scattering phase
        for (int i = 0; i < array.length; i++) {
            buckets[hash(array[i])].add(array[i]);
        }

        //ref: sorting phase
        for (List<Integer> bucket: buckets) {
            for (int i = 1; i < bucket.size(); i++) {
                int el = bucket.get(i);
                int j = i;
                while (j > 0 && bucket.get(j - 1) > el) {
                    bucket.set(j, bucket.get(j - 1));
                    j--;
                }
                bucket.set(j, el);
            }
        }
//        for (List list: buckets) {
//            Collections.sort(list);
//        }

        //ref: merging phase
        int i = 0;
        for (List<Integer> list: buckets) {
            for (int val: list) {
                array[i++] = val;
            }
        }
    }

    private static int hash(int digit) {
        return (digit / 10) % 10;
    }
}
