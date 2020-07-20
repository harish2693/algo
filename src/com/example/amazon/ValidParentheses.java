// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

package com.example.amazon;

import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(validateString("(())[]{}"));
        System.out.println(isValid("(())[]{}"));
    }

    public static boolean validateString(String input) {
        if (input == null || input.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> validCharacters = new HashMap<>();
        validCharacters.put('(', ')');
        validCharacters.put('[', ']');
        validCharacters.put('{', '}');

        int i = 0;
        while (i < input.length()) {
            Character closingCharacter = validCharacters.get(input.charAt(i));

            if (closingCharacter == null) {
                return false;
            }

            if (!closingCharacter.equals(input.charAt(i+1))) {
                return false;
            }

            i = i + 2;
        }

        return true;
    }

    public static boolean isValid(String s) {
        if(s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if(s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if(s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
