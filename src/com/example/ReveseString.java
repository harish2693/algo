package com.example;

public class ReveseString {

    public static void main(String[] args) {
        System.out.println(reverseOne("Harish"));
        System.out.println(reverseRecursive("Harish"));
    }

    public static String reverseOne(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static String reverseIterative(String input) {
        char[] output = new char[input.length()];
        for (int i = 0; i<input.length(); i++) {
            output[i] = input.charAt(input.length() - 1 - i);
        }
        return String.valueOf(output);
    }

    public static String reverseRecursive(String input) {
        if (input.isEmpty()) {
            return input;
        }

        return reverseIterative(input.substring(1)) + input.charAt(0);
    }
}
