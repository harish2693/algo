package com.example.amazon;

public class MultiplyWithoutStar {

    public static void main(String[] args) {
        System.out.println(multiply(2, 3));
    }

    public static int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (b > 0) {
            return a + multiply(a, b-1);
        } else {
            return -multiply(a, -b);
        }
    }
}
