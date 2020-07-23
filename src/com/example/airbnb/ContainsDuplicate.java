//Given an array of integers, find if the array contains any duplicates. Your function should return
//true if any value appears at least twice in the array, and it should return false if every element is distinct.

package com.example.airbnb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(verifyDuplicatesAlternative(new int[] {2, 3, 4, 5, 2}));
    }

    public static boolean verifyDuplicates(int[] input) {
        Set<Integer> set = new HashSet<>();

        for (int value: input) {
            boolean result = set.add(value);
            if (!result) {
                return true;
            }
        }

        return false;
    }

    public static boolean verifyDuplicatesAlternative(int[] input) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int value: input) {
            if (map.containsKey(value)) {
                return true;
            } else {
                map.put(value, 1);
            }
        }
        return false;
    }
}
