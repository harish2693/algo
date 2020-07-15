// Given a non-empty string s and a dictionary word Dict containing a list of non-empty words, determine if s can be
// segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not
// contain duplicate words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".

package com.example.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        String input = "leetcode";
        Set<String> dict = new HashSet<>(Arrays.asList("leet", "code"));
        System.out.println(wordBreak(input, dict));
    }

    public static boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
