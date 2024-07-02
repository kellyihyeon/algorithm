package com.github.kellyihyeon.section05stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1부터 n 까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써 하나의 수열을 만들 수 있다.
 * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지, 있다면 어떤 순서로 push & pop 연산을 수행해야 하는지를 알아내라.
 */
public class StackSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int count = 1;
        StringBuilder answer = new StringBuilder();

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            while (count <= num) {
                stack.push(count);
                answer.append("+\n");

                count++;
            }

            if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            answer.append("-\n");
        }

        System.out.println(answer);
    }
}
