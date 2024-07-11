package com.github.kellyihyeon.section08stackutilization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호의 균형이 맞는지 판단하라.
 * 입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다
 * " ."와 같이 괄호가 하나도 없는 경우도 균형잡힌 문자열로 간주할 수 있다.
 */
public class BalancedUniverse {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();

            if (s.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                isValid = false;
            }

            if (isValid) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
