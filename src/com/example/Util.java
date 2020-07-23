package com.example;

import java.util.LinkedHashSet;

public class Util {

    private static final int[] sortedData = {2, 10, 15, 17, 20, 29, 54};

    private static final int[] unSortedData = {87, 32, 80, 23, 12, 19, 1, 6};

    public static int[] getSortedData() {
        return sortedData.clone();
    }

    public static int[] getUnSortedData() {
        return unSortedData.clone();
    }

    public static void swap(int[] input, int i, int j) {
        LinkedHashSet<String> a = new LinkedHashSet<>();
        a.add("Hello");
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
