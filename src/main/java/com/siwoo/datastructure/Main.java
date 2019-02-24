package com.siwoo.datastructure;


import java.util.*;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
//        String[] array = {"q", "q"};
//        System.out.println( main.stringsRearrangement(array) );
//
        Main main = new Main();
        //int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array = {1, 2, 1, 2, 1, 2, 1, 2};
        System.out.println(Arrays.toString(main.extractEachKth(array, 2)));
        System.out.println(Arrays.toString(main.extractEachKth(array, 3)));

        String str = "var_1__Int";
        System.out.println(main.firstDigit(str));
        str = "cabca";
//        System.out.println(main.differentSymbolsNaive(str));
        array = new int[]{2, 3, 5, 1, 6};
//        array = new int[]{3, 2, 1, 1};
//        array = new int[]{1, 3, 2, 4};
//        System.out.println(main.arrayMaxConsecutiveSum(array, 2));
        //System.out.println(main.arrayMaxConsecutiveSum(array, 1));
//        System.out.println(main.arrayMaxConsecutiveSum(array, 3));

//        System.out.println(main.growingPlant(100, 10, 910));
        //System.out.println(main.growingPlant(10, 9, 4));

//        System.out.println(main.knapsackLight(10, 5, 6, 4, 8));
//        System.out.println(main.knapsackLight(10, 5, 6, 4, 9));
//        System.out.println(main.knapsackLight(5,3,7, 4, 6));
//        System.out.println(main.knapsackLight(10,2,11, 3, 1));

        System.out.println(main.longestDigitsPrefix("12abc34"));
        System.out.println(main.longestDigitsPrefix("the output is 42"));
        System.out.println(main.longestDigitsPrefix("0123456789"));
    }

    String longestDigitsPrefix(String str) {
        String el = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isWhitespace(c))
                break;
            if (Character.isDigit(c)) {
                int count = 0;
                int end = i + 1;
                while (end < str.length() - 1) {
                    char l = str.charAt(end);
                    if (Character.isDigit(l)) {
                        end++;
                        count++;
                    } else {
                        break;
                    }
                }
                if (el.length() < count)
                    el = str.substring(i, end);
                i = end + 1;
            }
        }
        return el;
    }


    int knapsackLight(int v1, int w1, int v2, int w2, int maxW) {
        final int max = Integer.max(Integer.max(w1, w2), maxW);
        int result = 0;
        if (max != maxW) return 0;
        if (w1 <= max) result = Integer.max(result, v1);
        if (w2 <= max) result = Integer.max(result, v2);
        if (w1 + w2 <= max) result = v1 + v2;
        return result;
    }

    int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
        Plant p = new Plant(upSpeed, downSpeed);
        int height = p.height;
        int days = 1;
        while (height <= desiredHeight) {
            p.increaseInDay();
            if (p.height >= desiredHeight)
                break;
            p.increaseInNight();
            height = p.height;
            days++;
        }
        return days;
    }


    class Plant {
        private int height;
        private int upSpeed;
        private int downSpeed;

        public Plant(int upSpeed, int downSpeed) {
            this.height = 0;
            this.upSpeed = upSpeed;
            this.downSpeed = downSpeed;
        }

        public void increaseInNight() {
            height -= downSpeed;
        }

        public void increaseInDay() {
            height += upSpeed;
        }
    }

    int arrayMaxConsecutiveSum(int[] array, int k) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            results.add(consecutiveSum(array, i, k));
        }
        System.out.println(results);
        return results.stream().max(Integer::compareTo).orElseThrow(IllegalArgumentException::new);
    }

    // n + (n + 1)
    private int consecutiveSum(int[] array, int n, int range) {
        if (array.length < n + range)
            return Integer.MIN_VALUE;
        int sum = 0;
        for (int i = n; i < n + range; i++) {
            sum += array[i];
        }
        return sum;
    }

    int differentSymbolsNaive(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.indexOf(c + "") == -1) {
                sb.append(c);
            }
        }
        return sb.length();
    }


    char firstDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c))
                return c;
        }
        throw new IllegalArgumentException();
    }

    int[] extractEachKth(int[] array, int th) {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 1; i <= array.length; i++) {
            if (i % th == 0)
                continue;
            tmp.add(array[i - 1]);
        }
        return tmp.stream().mapToInt(i -> i.intValue()).toArray();
    }

    private List<String[]> perms = new ArrayList<>();

    private boolean stringsRearrangement(String[] array) {
        permutation(array, 0, array.length);
        for (String[] seq: perms) {
            if (check(seq))
                return true;
        }
        return false;
    }

    private boolean check(String[] seq) {
        for (int i = 0; i < seq.length - 1; i++) {
            int count = 0;
            for (int j = 0; j < seq[i].length(); j++) {
                char c = seq[i].charAt(j);
                char nextC = seq[i + 1].charAt(j);
                if (c != nextC)
                    count++;
            }
            if (count != 1)
                return false;
        }
        return true;
    }

    private void permutation(String[] array, int depth, int max) {
        if (depth == max) {
            String[] newSeq = new String[array.length];
            System.arraycopy(array, 0, newSeq, 0, array.length);
            perms.add(newSeq);
            return;
        }
        for (int i = 0; i < array.length; i++) {
            swap(i, depth, array);
            permutation(array, depth + 1, max);
            swap(i, depth, array);
        }
    }

    private void swap(int i, int j, String[] array) {
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}

