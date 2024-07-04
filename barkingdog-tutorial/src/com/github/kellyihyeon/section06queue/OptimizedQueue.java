package com.github.kellyihyeon.section06queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 정수를 저장하는 큐를 구현하고 입력으로 주어지는 명령을 처리하라.
 * 명령
 * push x: 정수 x를 큐에 넣는 연산
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력 (없으면 -1)
 * size: 큐에 들어있는 정수의 개수를 출력
 * empty: 큐가 비어있으면 1, 아니면 0을 출력
 * front: 큐의 가장 앞에 있는 정수를 출력 (없으면 -1)
 * back: 큐의 가장 뒤에 있는 정수를 출력 (없으면 -1)
 *
 * !!! 명령의 수 n (1 ≤ N ≤ 2,000,000) !!!
 * 정수 x (1 ≤ N ≤ 100,000)
 */
public class OptimizedQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            String command = input[0];

            switch (command) {
                case "push":
                    int val = Integer.parseInt(input[1]);
                    queue.add(val);
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue.poll() + "\n");
                    }
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    bw.write((queue.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue.peek() + "\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(((LinkedList<Integer>) queue).getLast() + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
