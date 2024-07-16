package com.github.kellyihyeon.section08stackutilization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 주어진 괄호열을 읽고 그 괄호값을 계산하라.
 * ‘()’ 인 괄호열의 값은 2이다.
 * ‘[]’ 인 괄호열의 값은 3이다.
 * ‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
 * ‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
 * 올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.
 */
public class BracketValueCalculator {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int num = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                num *= 2;
                stack.push(c);
            } else if (c == '[') {
                num *= 3;
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }

                if (s.charAt(i - 1) == '(') {
                    sum += num;
                }
                stack.pop();
                num /= 2;
            } else { // c == ']'
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }

                if (s.charAt(i - 1) == '[') {
                    sum += num;
                }
                stack.pop();
                num /= 3;
            }
        }

        if (stack.isEmpty()) {
            System.out.println(sum);
        } else {
            System.out.println(0);
        }
    }
}
