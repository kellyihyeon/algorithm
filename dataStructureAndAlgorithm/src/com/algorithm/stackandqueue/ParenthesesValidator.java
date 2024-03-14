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
