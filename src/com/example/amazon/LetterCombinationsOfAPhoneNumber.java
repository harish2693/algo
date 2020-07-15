// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.

// 2 - abc
// 3 - def
// 4 - ghi
// 5 - jkl
// 6 - mno
// 7 - pqrs
// 8 - tuv
// 9 - wxyz

// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

package com.example.amazon;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    private static String[] mapping = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        String input = "234";

        if (input != null && input.length() > 0) {

            letterCombinationRecursive(result, input, "", 0, mapping);
        }
        //System.out.println(result);
        iterativeApproach("234");

    }

    private static void letterCombinationRecursive(List<String> result, String input, String current, int index, String[] mapping) {
        if (index == input.length()) {
            result.add(current);
            return;
        }

        String currentMapping = mapping[input.charAt(index) - '0'];

        for (int i = 0; i < currentMapping.length(); i++) {
            letterCombinationRecursive(result, input, current + currentMapping.charAt(i), index + 1, mapping);
        }
    }

    private static void iterativeApproach(String digits) {
        List<String> result = new ArrayList<>();
        result.add("");
        for (char dig: digits.toCharArray()) {
            List<String> track = new ArrayList<>();
            for (char letter: mapping[dig - '0'].toCharArray()) {
                for (String prefix: result) {
                    track.add(prefix + letter);
                }
            }
            result = track;
        }
        System.out.println(result);
    }
}
