//Given an array of integers and an integer k, find out whether there are two distinct indices i and
//j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

package com.example.airbnb;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicatesII {

    public static void main(String[] args) {
        System.out.println(verifyDiff(new int[]{3, 2, 1, 3, 5}, 2));
    }

    public static boolean verifyDiff(int[] input, int diff) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < input.length; k++) {
            if (map.containsKey(input[k])) {
                int i = map.get(input[k]);
                if ((k-i) <= diff) {
                    return true;
                }
            } else {
                map.put(input[k], k);
            }
        }

        return false;
    }
}
