//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//You may assume that the array is non-empty and the majority element always exist in the array.

package com.example.adobe;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 3, 3}));
    }

    public static int majorityElement(int[] input) {
        if (input.length == 1) {
            return input[0];
        }
        Map<Integer, Integer> map = new HashMap<>();

        for(int current: input) {
            if(map.containsKey(current) && map.get(current) + 1 > input.length / 2) {
                return current;
            } else if(map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }

        return -1;
    }
}
