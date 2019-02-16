package com.siwoo.datastructure;

import com.siwoo.datastructure.practice.*;
import com.siwoo.datastructure.sort.Sorter;


public class SorterMain {

    public static void main(String[] args) {
        Integer[] array = { 20, 35, -15, 7, 55, 1, -22 };
//      Sorter<Integer> sorter = new BubbleSorter<>();
//      Sorter<Integer> sorter = new SelectionSorter<>();
//      Sorter<Integer> sorter = new InsertionSorter<>();
//      Sorter<Integer> sorter = new ShellSorter<>();
        Sorter<Integer> sorter = new MergeSorter<>();
        sorter.sort(array);
        sorter.print(array);

//        System.out.println(iterativeFactorial(25));
//        System.out.println(recurFactorial(25));
    }


    //3! = 3 * 2!
    //2! = 2 * 1!
    //1! = 1 * 0!
    //0! = 1
    private static int recurFactorial(int num) {
        if (num == 0) return 1;
        return num * recurFactorial(num - 1);
    }

    //3! = 3 * 2!
    //2! = 2 * 1!
    //1! = 1 * 0!
    //0! = 1
    public static int iterativeFactorial(int num) {
        if (num == 0) return 1;
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

}
