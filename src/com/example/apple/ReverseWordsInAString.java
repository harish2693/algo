//Given an input string, reverse the string word by word.
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".

package com.example.apple;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String input) {
        String[] inputArray = input.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = inputArray.length - 1; i > 0; i--) {
            stringBuilder.append(inputArray[i]).append(" ");
        }
        return stringBuilder.append(inputArray[0]).toString();
    }
}
