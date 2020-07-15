// Given an array of strings, group anagrams together.

// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Return:

// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note: All inputs will be in lower-case.

package com.example.amazon;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Arrays.sort(input);
        Map<Integer, List<String>> result = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            int sum = getAscii(input[i]);

            if (result.containsKey(sum)) {
                result.get(sum).add(input[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(input[i]);
                result.put(sum, temp);
            }
        }

        System.out.println(result.values());
    }

    private static int getAscii(String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += (int) value.charAt(i);
        }
        return sum;
    }


}
