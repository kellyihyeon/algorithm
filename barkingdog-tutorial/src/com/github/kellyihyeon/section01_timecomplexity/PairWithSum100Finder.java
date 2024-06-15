package com.github.kellyihyeon.section01_timecomplexity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 주어진 길이 n의 int 배열 arr 에서 합이 100인 서로 다른 위치의 두 원소가 존재하면 1,
 * 존재하지 않으면 0을 반환하는 함수를 작성하라.
 * arr 의 각 수는 0이상 100이하, n은 1000 이하이다.
 */
public class PairWithSum100Finder {

    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 52, 48};

        int n2 = 2;
        int[] arr2 = {50, 42};

        int n3 = 4;
        int[] arr3= {4, 13, 63, 87};

        int answer = new PairWithSum100Finder().solution(arr2, n2);
        System.out.println(answer);
    }

    public int solution(int arr[], int n) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i : arr) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int qualifyingNumber = 100 - queue.poll();

            if (queue.contains(qualifyingNumber)) {
                return 1;
            }
        }

        return 0;
    }
}
