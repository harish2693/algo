//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

//Example:
//Input: "babad"
//Output: "bab"

//Note: "aba" is also a valid answer.

//Example:
//Input: "cbbd"
//Output: "bb"

package com.example.amazon;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String input = "cbbd";
        System.out.println(longestPalindrome(input));
    }

    public static String longestPalindrome(String input) {
        if (input.isEmpty()) {
            return "";
        }

        int n = input.length();
        int longestSoFar = 0;
        int startIndex = 0;
        int endIndex = 0;

        boolean[][] palindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (input.charAt(i) == input.charAt(j) && (i - j <= 2 || palindrome[j + 1][i - 1])) {
                    palindrome[j][i] = true;
                    if (i - j + 1 > longestSoFar) {
                        longestSoFar = i - j + 1;
                        startIndex = j;
                        endIndex = i;
                    }
                }
            }
        }
        return input.substring(startIndex, endIndex + 1);
    }

    public static String longestPalindromeAlternative(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}
