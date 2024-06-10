package com.algorithm.tree;

import java.util.PriorityQueue;
import java.util.Queue;

public class ScovilleHeatUnit {

    // 35 min
    public static void main(String[] args) {
        int k = 7;
        int[] scovilles = {1, 2, 3, 9, 10, 12};

        int answer = new ScovilleHeatUnit().solution(scovilles, k);
        System.out.println("answer = " + answer);
    }

    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int unit : scoville) {
            queue.offer(unit);
        }

        int mixed = 0;
        while (!queue.isEmpty()) {
            Integer minimum = queue.poll();
            Integer secondSmallestValue = queue.poll();

            if (secondSmallestValue == null) {
                if (minimum >= K) {
                    return mixed;
                }
                break;
            }

            if (minimum >= K && secondSmallestValue >= K) {
                return mixed;
            }

            int mixedScovilleHeatUnit = minimum + (secondSmallestValue * 2);
            queue.offer(mixedScovilleHeatUnit);
            mixed++;
        }

        return -1;
    }

}
