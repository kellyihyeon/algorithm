package com.github.kellyihyeon.section08stackutilization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 두개의 괄호 기호인 "(" 와 ")" 만으로 구성되어 있는 문자열이 있다.
 * 괄호의 모양이 바르게 구성된 문자열은 올바른 괄호 문자열(Valid Parenthesis String)이다.
 * 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지 판단하라.
 */
public class ParenthesisString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for (char c : br.readLine().toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || stack.peek() != '(') {
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
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
