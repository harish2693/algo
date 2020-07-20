package com.example.search;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] data = {3, 2, 6, 1, 10, 9, 102, 67};
        Arrays.sort(data);
        System.out.println(binarySearchRecursive(data, 10, 0, data.length - 1));
    }

    public static boolean binarySearch(int[] sortedData, int x) {
        int end = sortedData.length - 1;
        int start = 0;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (sortedData[mid] == x) return true;
            else if (sortedData[mid] > x) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }

    public static boolean binarySearchRecursive(int[] sortedData, int x, int start, int end) {
        if (start <= end) {
            int mid = (end - start) / 2 + start;
            if (sortedData[mid] == x) return true;
            if (sortedData[mid] > x)
                return binarySearchRecursive(sortedData, x, start, mid-1);
            return binarySearchRecursive(sortedData, x, mid + 1, end);
        }
        return false;
    }
}
