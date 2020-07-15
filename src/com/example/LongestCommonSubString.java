package com.example;

public class LongestCommonSubString {

    public static void main(String[] args) {
        System.out.println(longestCommonSubSequence("abacd", "ubac"));
    }

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
