package com.example;

public class LongestCommonSubString {

    public static void main(String[] args) {
        System.out.println(longestCommonSubSequence("abacd", "ubac"));
    }

    /**
     *      a(0) b(1) a(2) c(3) d(4)
     * u(0)  0    0    0    0    0
     * b(1)  0    0    0    0    0
     * a(2)  0    0    0    0    0
     * c(3)  0    0    0    0    0
     *
     * max = 0
     * endIndex = -1
     *
     * i = 0
     *
     * j = 0
     *
     * input1.charAt(0) == input2.charAt(0)
     * a == u false
     *
     * j = 1
     *
     * input1.charAt(0) == input2.charAt(1)
     * a == b
     *
     * j = 2
     *
     * input1.charAt(0) == input2.charAt(2)
     * a == a true
     * if (i == 0 || j == 0) {
     *   dp[i][j] = 1;
     *   dp[0][2] = 1
     * } else {
     *   dp[i][j] = dp[i - 1][j - 1] + 1;
     * }
     * if (max < dp[i][j]) {
     *   max = dp[i][j];
     *   endIndex = i;
     *   max = 1;
     *   endIndex = 0;
     * }
     *
     *      a(0) b(1) a(2) c(3) d(4)
     * u(0)  0    0    1    0    0
     * b(1)  0    0    0    0    0
     * a(2)  0    0    0    0    0
     * c(3)  0    0    0    0    0
     *
     *
     * j = 3
     *
     * input1.charAt(0) == input2.charAt(3)
     * a == c
     *
     * i = 1
     *
     * j = 0
     *
     * input1.charAt(1) == input2.charAt(0)
     * b == u
     *
     * j = 1
     *
     * input1.charAt(1) == input2.charAt(1)
     * b == b
     *
     * j = 2
     *
     * input1.charAt(1) == input2.charAt(2)
     * b == a
     *
     * j = 3
     *
     * input1.charAt(1) == input2.charAt(3)
     * b == c
     *
     * i = 2
     *
     * j = 0
     *
     * input1.charAt(2) == input2.charAt(0)
     * a == u
     *
     * j = 1
     *
     * input1.charAt(2) == input2.charAt(1)
     * a == b
     *
     * j = 2
     *
     * input1.charAt(2) == input2.charAt(2)
     * a == a
     *
     * j = 3
     *
     * input1.charAt(2) == input2.charAt(3)
     * a == c
     *
     * i = 3
     *
     * j = 0
     *
     * input1.charAt(3) == input2.charAt(0)
     * c == u
     *
     * j = 1
     *
     * input1.charAt(3) == input2.charAt(1)
     * c == b
     *
     * j = 2
     *
     * input1.charAt(3) == input2.charAt(2)
     * c == a
     *
     * j = 3
     *
     * input1.charAt(3) == input2.charAt(3)
     * c == c
     *
     * i = 4
     *
     * j = 0
     *
     * input1.charAt(4) == input2.charAt(0)
     * d == u
     *
     * j = 1
     *
     * input1.charAt(4) == input2.charAt(1)
     * d == b
     *
     * j = 2
     *
     * input1.charAt(4) == input2.charAt(2)
     * d == a
     *
     * j = 3
     *
     * input1.charAt(4) == input2.charAt(3)
     * d == c
     *
     *
     *
     * @param input1
     * @param input2
     * @return
     */
    private static String longestCommonSubSequence(String input1, String input2) {
        int[][] dp = new int[input1.length()][input2.length()];

        int max = 0;
        int endIndex = -1;

        for (int i = 0; i < input1.length(); i++) {
            for (int j = 0; j < input2.length(); j++) {
                if (input1.charAt(i) == input2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }
        return input1.substring(endIndex - max + 1, endIndex + 1);
    }
}
