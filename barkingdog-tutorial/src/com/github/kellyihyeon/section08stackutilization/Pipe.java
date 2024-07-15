package com.github.kellyihyeon.section08stackutilization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Pipe {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] parenthesis = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int pipe = 0;
        boolean laser = false;
        int answer = 0;

        for (char c : parenthesis) {
            if (c == '(') {
                stack.push(c);
                pipe++;
            } else {  // c == ')'
                if (stack.peek() == '(') {
                    laser = true;
                    stack.pop();
                } else {  // 막대기의 끝인 경우
                    answer += 1;
                }

                stack.push(c);
                pipe--;
            }

            if (laser) {
                answer += pipe;
            }

            laser = false;
        }
        System.out.println(answer);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                // 1.레이저인 경우
                if (s.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {  // 2.막대기가 끝난 경우
                    stack.pop();
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
