package com.github.kellyihyeon.section07Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * n개의 원소를 포함하고 있는 양방향 순환 큐가 있다.
 * 큐에서 3가지 연산을 수행할 수 있다.
 * 1. 첫 번째 원소를 뽑는다.
 * 2. 왼쪽으로 한 칸 이동한다. (1 2 3 -> 2 3 1)
 * 3. 오른쪽으로 한 칸 이동한다. (1 2 3 -> 3 1 2)
 *
 * 큐의 크기 n, 뽑아내려고 하는 수의 개수 m
 * 뽑아내려고 하는 수의 위치가 주어졌을 때, 주어진 순서대로 뽑아내는데 드는 2번,3번 연산의 최솟값을 출력하라.
 */
public class RotatingQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.add(i + 1);
        }

        String[] targets = br.readLine().split(" ");
        int count = 0;

        // 앞에서부터의 거리 계산
        for (String target : targets) {
            int t = Integer.parseInt(target);
            int index = 0;
            for (Integer num : deque) {
                if (num == t) {
                    break;
                }
                index++;
            }

            // 타겟이 나올 때까지 회전
            while (deque.peekFirst() != t) {
                int reverseIndex = deque.size() - index;

                if (index > reverseIndex) {
                    deque.addFirst(deque.removeLast());
                } else {
                    deque.addLast(deque.removeFirst());
                }
                count++;
            }

            deque.removeFirst();
        }

        System.out.println(count);
    }
}
