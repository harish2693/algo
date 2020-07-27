//Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
//Examples:
//
//s = "leetcode"
//return 0.
//
//s = "loveleetcode",
//return 2.
//Note: You may assume the string contain only lowercase letters.

package com.example.amazon;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String input = "leetcode";

        System.out.println(getIndex(input));
    }

    private static int getIndex(String input) {
        Map<Character, Integer> characters = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (characters.containsKey(current)) {
                characters.put(current, -1);
            } else {
                characters.put(current, i);
            }
        }

        int min = Integer.MAX_VALUE;
        for (char c: characters.keySet()) {
            if (characters.get(c) > -1 && characters.get(c) < min) {
                min = characters.get(c);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
