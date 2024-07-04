package com.github.kellyihyeon.section05stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * n개의 높이가 서로 다른 탑이 수평 직선에 일렬로 서 있고, 모든 탑에서는 왼쪽 방향으로 동시에 레이저 신호를 발사한다.
 * 하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능하다.
 * 각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지 알아내라.
 * 1 <= n <= 500,000, 1<=탑들의 높이<=100,000,000
 */
public class LaserTower {

    static class Tower {
        int height;
        int order;

        public Tower(int height, int order) {
            this.height = height;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Tower> stack = new Stack<>();
        stack.push(new Tower(Integer.MAX_VALUE, 0));

        for (int i = 1; i < n + 1; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (stack.peek().height < height) {
                stack.pop();
            }

            System.out.print(stack.peek().order + " ");
            stack.push(new Tower(height, i));
        }
    }
}
