package com.algorithm.stackandqueue;

import java.util.Stack;

public class ParenthesesValidator {

    public static void main(String[] args) {
        String s = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        boolean answer = new ParenthesesValidator().solution(s);
        System.out.println("answer = " + answer);
    }

    boolean useInteger(String s) {
        int stack = 0;
        for (char c : s.toCharArray()) {
            if ('(' == c) {
                stack++;
            } else {
                if (stack == 0) {
                    return false;
                }
                stack--;
            }
        }
        return stack == 0;
    }

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char character : s.toCharArray()) {
            if ("(".equals(String.valueOf(character))) {
                stack.push(character);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
        }

        return stack.isEmpty();
    }
}
