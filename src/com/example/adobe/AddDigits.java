//Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

//For example:
//Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

//Follow up:
//Could you do it without any loop/recursion in O(1) runtime?

package com.example.adobe;

public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigitsRecursion(38));
        System.out.println(addDigitsAlternate(38));
    }

    public static int addDigits(int number) {
        while (number >= 10) {
            int temp = 0;
            while (number > 0) {
                temp += number % 10;
                number /= 10;
            }
            number = temp;
        }
        return number;
    }

    public static int addDigitsRecursion(int number) {
        int sum = 0;

        String s = String.valueOf(number);
        for (int i = 0; i < s.length(); i++) {
            sum = sum + (s.charAt(i) - '0');
        }

        if (sum < 10) {
            return sum;
        } else {
            return addDigitsRecursion(sum);
        }
    }

    public static int addDigitsAlternate(int number) {
        if (number == 0) {
            return 0;
        }
        return (number % 9 == 0) ? 9 : (number % 9);
    }
}
