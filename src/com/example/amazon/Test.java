package com.example.amazon;

public class Test {

    public static void main(String[] args) {
        String input = "GE HEALTHCARE";
        String[] result = input.split("\\s+");
        String output = "";
        for (int i = result.length - 1; i >= 0; i--) {
            output += result[i];
        }
        System.out.println(output);
    }
}
