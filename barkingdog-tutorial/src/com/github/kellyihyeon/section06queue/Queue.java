package com.github.kellyihyeon.section06queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수를 저장하는 큐를 구현하고 입력으로 주어지는 명령을 처리하라.
 * 명령
 * push x: 정수 x를 큐에 넣는 연산
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력 (없으면 -1)
 * size: 큐에 들어있는 정수의 개수를 출력
 * empty: 큐가 비어있으면 1, 아니면 0을 출력
 * front: 큐의 가장 앞에 있는 정수를 출력 (없으면 -1)
 * back: 큐의 가장 뒤에 있는 정수를 출력 (없으면 -1)
 * 명령의 수 n (1 ≤ N ≤ 10,000)
 * 정수 x (1 ≤ N ≤ 100,000)
 */
public class Queue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] queue = new int[10000];
        int head = 0;
        int tail = 0;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    queue[tail++] = x;
                    break;
                case "pop":
                    if (head == tail) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue[head++]);
                    }
                    break;
                case "size":
                    System.out.println(tail - head);
                    break;
                case "empty":
                    System.out.println(head == tail ? 1 : 0);
                    break;
                case "front":
                    if (head == tail) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue[head]);
                    }
                    break;
                case "back":
                    if (head == tail) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue[tail - 1]);
                    }
                    break;
            }

        }
    }
}
