package com.siwoo.datastructure;

import com.siwoo.datastructure.practice.*;
import com.siwoo.datastructure.sort.*;
import com.siwoo.datastructure.sort.QuickSorter;


public class SorterMain {

    public static void main(String[] args) {
        Integer[] array = { 20, 35, -15, 7, 55, 1, -22 };
        SortContext<Integer> context = new SortContext<>();
//      Sorter<Integer> sorter = new BubbleSorter<>();
//      Sorter<Integer> sorter = new SelectionSorter<>();
//      Sorter<Integer> sorter = new InsertionSorter<>();
//      Sorter<Integer> sorter = new ShellSorter<>();
//        Sorter<Integer> sorter = new MergeSorter<>();
//        Sorter<Integer> sorter = new QuickSorter<>();
//        context.setSorter(sorter);
//        context.doSort(array);
//        context.print(array);

        array = new Integer[]{ 2, 6, 9, 8, 2, 8, 7, 10, 4, 3 };
        RangeSort sorter = new CountSorter();
        context.setSorter(sorter);
        context.doSortInRange(array, 1, 10);
        context.print(array);
        System.out.println(iterativeFactorial(25));
        System.out.println(recurFactorial(25));
    }

    //3! = 3 * 2!
    //2! = 2 * 1!
    //1! = 1 * 0!
    //0! = 1
    private static int iterativeFactorial(int num) {
        if (num == 0) return 1;
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    //3! = 3 * 2!
    //2! = 2 * 1!
    //1! = 1 * 0!
    //0! = 1
    private static int recurFactorial(int num) {
        if (num == 0) return 1;
        return num * iterativeFactorial(num - 1);
    }
}
