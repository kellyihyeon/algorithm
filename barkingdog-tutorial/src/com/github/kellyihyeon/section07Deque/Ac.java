package com.github.kellyihyeon.section07Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * AC 라는 언어에는 R(뒤집기), D(버리기) 함수가 있다.
 * R(뒤집기): 배열에 있는 수의 순서를 뒤집는다.
 * D(버리기): 첫 번째 수를 버린다. 비어있는 경우 에러 발생
 * 배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하라.
 */
public class Ac {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            Deque<Integer> deque = new LinkedList<>();

            char[] functions = br.readLine().toCharArray();
            br.readLine();
            String[] rawArrays = br.readLine().replace('[', ' ').replace(']', ' ').trim().split(",");

            for (String rawArray : rawArrays) {
                if (!rawArray.isEmpty()) {
                    deque.add(Integer.parseInt(rawArray));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char function : functions) {
                if (function == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        isError = true;
                        break;
                    }

                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (isError) {
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");

            if (isReversed) {
                while (!deque.isEmpty()) {
                    sb.append(deque.removeLast()).append(",");
                }
            } else {
                while (!deque.isEmpty()) {
                    sb.append(deque.removeFirst()).append(",");
                }
            }

            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("]");

            System.out.println(sb);
        }
    }
}
