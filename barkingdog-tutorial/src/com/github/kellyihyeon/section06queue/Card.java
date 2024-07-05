package com.github.kellyihyeon.section06queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * n장의 카드가 있다. 카드는 1부터 n 까지의 번호가 붙어 있다.
 * 1번 카드가 제일 위, n번 카드가 제일 아래인 상태로 순서대로 카드가 놓여있다.
 * 해당 행위를 카드가 한 장 남을 때까지 반복했을 때, 제일 마지막에 남게 되는 카드를 구하라.
 *    1. 제일 위에 있는 카드를 바닥에 버린다.
 *    2. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
 */
public class Card {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i + 1);
        }

        while (queue.size() != 1) {
            queue.poll();
            int card = queue.poll();
            queue.offer(card);
        }

        System.out.println(queue.peek());
    }
}
