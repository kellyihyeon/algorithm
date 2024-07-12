package com.github.kellyihyeon.section08stackutilization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * A는 A끼리, B는 B끼리 쌍을 짓는다.
 * 만약 선끼리 교차하지 않으면서 쌍을 지을 수 있다면 그 단어는 '좋은 단어' 이다.
 * 좋은 단어의 개수를 세어보자.
 */
public class GoodWord {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        while (n-- > 0) {
            char[] values = br.readLine().toCharArray();

            Stack<Character> stack = new Stack<>();
            for (char value : values) {
                if (!stack.isEmpty() && stack.peek() == value) {
                    stack.pop();
                } else {
                    stack.push(value);
                }
            }

            if (stack.isEmpty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}
