package com.example;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubSequence("abcfd", "abcd"));
    }

    private static String longestCommonSubSequence(String input1, String input2) {
        int[][] dp = new int[input1.length() + 1][input2.length() + 1];

        for (int i = 1; i <= input1.length(); i++) {
            for (int j = 1; j <= input2.length(); j++) {
                if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = 0;
        int j = 0;

        StringBuilder builder = new StringBuilder();
        while (i < input1.length() && j < input2.length()) {
            if (input1.charAt(i) == input2.charAt(j)) {
                builder.append(input1.charAt(i));
                i++;
                j++;
            } else if (dp[i+1][j] >= dp[i][j+1]) {
                i++;
            } else {
                j++;
            }
        }
        return builder.toString();
    }
}
