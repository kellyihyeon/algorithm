package com.github.kellyihyeon.section05stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 첫 번째 줄에 정수 k가 주어진다. (1 ≤ K ≤ 100,000)
 * 이후 k개의 줄에 정수가 1개씩 주어진다. 정수는 0<= n<=1,000,000 사이의 값을 가진다.
 * 정수가 0일 경우 가장 최근에 쓴 수를 지운다. 정수가 0일 경우에는 지울 수 있는 수가 있음을 보장한다.
 * 최종적으로 남은 수의 합을 출력하라.
 */
public class Zero {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        while (k-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                stack.push(num);
            } else {
                stack.pop();
            }
        }

        int answer = 0;
        for (Integer num : stack) {
            answer += num;
        }

        System.out.println(answer);
    }
}
