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
        String input = "cbebd";
        System.out.println(longestPalindrome(input));
    }

    /**
     * input = "cbbd"
     *
     * n = 4
     * longestSoFar = 0
     * startIndex = 0
     * endIndex = 0
     *
     * palindrome = new boolean[4][4]
     *
     *      c(0) b(1) b(2) d(3)
     * c(0)  t    f    f    f
     * b(1)  f    f    f    f
     * b(2)  f    f    f    f
     * d(3)  f    f    f    f
     *
     * i = 0
     *
     *      c(0) b(1) b(2) d(3)
     * c(0)  t    f    f    f
     * b(1)  f    f    f    f
     * b(2)  f    f    f    f
     * d(3)  f    f    f    f
     *
     * i = 1
     *
     *      c(0) b(1) b(2) d(3)
     * c(0)  t    f    f    f
     * b(1)  f    t    f    f
     * b(2)  f    f    f    f
     * d(3)  f    f    f    f
     *
     * j = 0
     * input.charAt(1) = b
     * input.charAt(0) = c
     * input.charAt(i) == input.charAt(j) false
     * j+1=1
     * i-1=0
     * 1 - 0 <= 2 || false
     *
     *
     *      c(0) b(1) b(2) d(3)
     * c(0)  t    f    f    f
     * b(1)  f    t    f    f
     * b(2)  f    f    f    f
     * d(3)  f    f    f    f
     *
     * i = 2
     *
     *      c(0) b(1) b(2) d(3)
     * c(0)  t    f    f    f
     * b(1)  f    t    f    f
     * b(2)  f    f    t    f
     * d(3)  f    f    f    f
     *
     * j = 0
     *
     * input.charAt(2) = b
     * input.charAt(0) = c
     * input.charAt(i) == input.charAt(j) false
     * j+1=1
     * i-1=1
     * 1 - 1 <= 2 || true
     *
     *      c(0) b(1) b(2) d(3)
     * c(0)  t    f    f    f
     * b(1)  f    t    f    f
     * b(2)  f    f    t    f
     * d(3)  f    f    f    f
     *
     * j = 1
     *
     * input.charAt(2) = b
     * input.charAt(1) = b
     * input.charAt(i) == input.charAt(j) true
     * j+1=2
     * i-1=1
     * 2 - 1 <= 2 || false
     * palindrome[1][2] = true;
     * if (i - j + 1 > longestSoFar) {
     *   longestSoFar = i - j + 1;
     *   startIndex = j;
     *   endIndex = i;
     * }
     *
     * if (2 - 1 + 1 > 0) {
     *     longestSoFar = 2 - 1 + 1 = 2;
     *     startIndex = 1;
     *     endIndex = 2;
     * }
     *
     *      c(0) b(1) b(2) d(3)
     * c(0)  t    f    f    f
     * b(1)  f    t    t    f
     * b(2)  f    f    t    f
     * d(3)  f    f    f    f
     *
     * i = 3
     *
     *      c(0) b(1) b(2) d(3)
     * c(0)  t    f    f    f
     * b(1)  f    t    t    f
     * b(2)  f    f    t    f
     * d(3)  f    f    f    t
     *
     * j = 0
     *
     * input.charAt(3) = d
     * input.charAt(0) = c
     * input.charAt(i) == input.charAt(j) false
     * j+1=1
     * i-1=2
     * 3 - 0 <= 2 || false
     *
     *      c(0) b(1) b(2) d(3)
     * c(0)  t    f    f    f
     * b(1)  f    t    t    f
     * b(2)  f    f    t    f
     * d(3)  f    f    f    t
     *
     * j = 1
     *
     * input.charAt(3) = d
     * input.charAt(1) = b
     * input.charAt(i) == input.charAt(j) false
     * j+1=1
     * i-1=0
     * 3 - 1 <= 2 || false
     *
     *      c(0) b(1) b(2) d(3)
     * c(0)  t    f    f    f
     * b(1)  f    t    t    f
     * b(2)  f    f    t    f
     * d(3)  f    f    f    t
     *
     * j = 2
     *
     * input.charAt(3) = d
     * input.charAt(2) = b
     * input.charAt(i) == input.charAt(j) false
     * j+1=1
     * i-1=0
     * 3 - 2 <= 2 || false
     *
     *      c(0) b(1) b(2) d(3)
     * c(0)  t    f    f    f
     * b(1)  f    t    t    f
     * b(2)  f    f    t    f
     * d(3)  f    f    f    t
     *
     * longestSoFar = 2;
     * startIndex = 1;
     * endIndex = 2;
     * input.substring(startIndex, endIndex + 1)
     * input.substring(1, 3) = bb
     *
     * input = "cbebd"
     *
     * n = 5
     * longestSoFar = 0
     * startIndex = 0
     * endIndex = 0
     *
     * palindrome = new boolean[5][5]
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f    f    f
     * b(1)  f    f    f    f    f
     * e(2)  f    f    f    f    f
     * b(3)  f    f    f    f    f
     * d(4)  f    f    f    f    f
     *
     * i = 0
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f    f    f
     * b(1)  f    f    f    f    f
     * e(2)  f    f    f    f    f
     * b(3)  f    f    f    f    f
     * d(4)  f    f    f    f    f
     *
     * i = 1
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t  a=f    f    f    f
     * b(1)b=f    t    f    f    f
     * e(2)  f    f    f    f    f
     * b(3)  f    f    f    f    f
     * d(4)  f    f    f    f    f
     *
     * j = 0
     * input.charAt(1) = b
     * input.charAt(0) = c
     * input.charAt(i) == input.charAt(j) false
     * j+1=1
     * i-1=0
     * 1 - 0 <= 2 || false
     *
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f    f    f
     * b(1)  f    t    f    f    f
     * e(2)  f    f    f    f    f
     * b(3)  f    f    f    f    f
     * d(4)  f    f    f    f    f
     *
     * i = 2
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f   a=f    f    f
     * b(1)  f  b=t    f    f    f
     * e(2)  f    f    t    f    f
     * b(3)  f    f    f    f    f
     * d(4)  f    f    f    f    f
     *
     * j = 0
     *
     * input.charAt(2) = e
     * input.charAt(0) = c
     * input.charAt(i) == input.charAt(j) false
     * j+1=1
     * i-1=1
     * 2 - 0 <= 2 || true
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f    f    f
     * b(1)  f    t  a=f    f    f
     * e(2)  f  b=f    t    f    f
     * b(3)  f    f    f    f    f
     * d(4)  f    f    f    f    f
     *
     * j = 1
     *
     * input.charAt(2) = e
     * input.charAt(1) = b
     * input.charAt(i) == input.charAt(j) false
     * j+1=2
     * i-1=1
     * 2 - 1 <= 2 || false
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f    f    f
     * b(1)  f    t    f    f    f
     * e(2)  f    f    t    f    f
     * b(3)  f    f    f    f    f
     * d(4)  f    f    f    f    f
     *
     * i = 3
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f  a=f    f
     * b(1)  f    t  b=f    f    f
     * e(2)  f    f    t    f    f
     * b(3)  f    f    f    t    f
     * d(4)  f    f    f    f    f
     *
     * j = 0
     *
     * input.charAt(3) = b
     * input.charAt(0) = c
     * input.charAt(i) == input.charAt(j) false
     * j+1=1
     * i-1=2
     * 3 - 0 <= 2 || false
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f    f    f
     * b(1)  f    t    f  a=f    f
     * e(2)  f    f  b=t    f    f
     * b(3)  f    f    f    t    f
     * d(4)  f    f    f    f    f
     *
     * j = 1
     *
     * input.charAt(3) = b
     * input.charAt(1) = b
     * input.charAt(i) == input.charAt(j) true
     * j+1=2
     * i-1=2
     * 3 - 1 <= 2 || true
     * palindrome[1][3] = true;
     * if (i - j + 1 > longestSoFar) {
     *   longestSoFar = i - j + 1;
     *   startIndex = j;
     *   endIndex = i;
     * }
     *
     * if (3 - 1 + 1 > 0) {
     *     longestSoFar = 3 - 1 + 1 = 3;
     *     startIndex = 1;
     *     endIndex = 3;
     * }
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f    f    f
     * b(1)  f    t    f    t    f
     * e(2)  f    f    t  a=f    f
     * b(3)  f    f  b=f    t    f
     * d(4)  f    f    f    f    f
     *
     * j = 2
     *
     * input.charAt(3) = b
     * input.charAt(2) = e
     * input.charAt(i) == input.charAt(j) false
     * j+1=3
     * i-1=2
     * 3 - 2 <= 2 || false
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f    f    f
     * b(1)  f    t    f    t   f
     * e(2)  f    f    t    f    f
     * b(3)  f    f    f    t    f
     * d(4)  f    f    f    f    f
     *
     * i = 4
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f    f  a=f
     * b(1)  f    t    f  b=t    f
     * e(2)  f    f    t    f    f
     * b(3)  f    f    f    t    f
     * d(4)  f    f    f    f    t
     *
     * j = 0
     *
     * input.charAt(4) = d
     * input.charAt(0) = c
     * input.charAt(i) == input.charAt(j) false
     * j+1=1
     * i-1=3
     * 4 - 0 <= 2 || false
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f    f    f
     * b(1)  f    t    f    t   a=f
     * e(2)  f    f    t  b=f    f
     * b(3)  f    f    f    t    f
     * d(4)  f    f    f    f    t
     *
     * j = 1
     *
     * input.charAt(4) = d
     * input.charAt(1) = b
     * input.charAt(i) == input.charAt(j) false
     * j+1=2
     * i-1=3
     * 4 - 1 <= 2 || false
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f    f    f
     * b(1)  f    t    f    t    f
     * e(2)  f    f    t    f  a=f
     * b(3)  f    f    f  b=t    f
     * d(4)  f    f    f    f    t
     *
     * j = 2
     *
     * input.charAt(4) = d
     * input.charAt(2) = e
     * input.charAt(i) == input.charAt(j) false
     * j+1=3
     * i-1=3
     * 4 - 2 <= 2 || false
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f    f    f
     * b(1)  f    t    f    t    f
     * e(2)  f    f    t    f    f
     * b(3)  f    f    f    t  a=f
     * d(4)  f    f    f  b=f    t
     *
     * j = 3
     *
     * input.charAt(4) = d
     * input.charAt(3) = b
     * input.charAt(i) == input.charAt(j) false
     * j+1=4
     * i-1=3
     * 4 - 3 <= 2 || false
     *
     *      c(0) b(1) e(2) b(3) d(4)
     * c(0)  t    f    f    f    f
     * b(1)  f    t    f    t    f
     * e(2)  f    f    t    f    f
     * b(3)  f    f    f    t    f
     * d(4)  f    f    f    f    t
     *
     * longestSoFar = 3;
     * startIndex = 1;
     * endIndex = 3;
     * input.substring(startIndex, endIndex + 1)
     * input.substring(1, 4) = beb
     *
     * @param input
     * @return
     */
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
