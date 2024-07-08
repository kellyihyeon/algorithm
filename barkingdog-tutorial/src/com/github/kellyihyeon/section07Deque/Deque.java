package com.github.kellyihyeon.section07Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 정수를 저장하는 덱을 구현한 다음, 입력으로 주어지는 명령을 처리하라.
 * 명령
 *   - push_front x: 정수 x를 덱의 앞에 넣는다.
 *   - push_back X: 정수 X를 덱의 뒤에 넣는다.
 *   - pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *   - pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *   - size: 덱에 들어있는 정수의 개수를 출력한다.
 *   - empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 *   - front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *   - back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *
 * 명령의 수 N (1 ≤ N ≤ 10,000)
 */
public class Deque {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> deque = new LinkedList<>();


        int value = 0;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    value = Integer.parseInt(st.nextToken());
                    deque.add(0, value);
                    break;
                case "push_back":
                    value = Integer.parseInt(st.nextToken());
                    deque.add(deque.size(), value);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.remove(0));
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.remove(deque.size() - 1));
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.get(0));
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.get(deque.size() - 1));
                    }
                    break;
                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
            }
        }
    }
}
