package arraysandhashing;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentElements347 {

    static class Count implements Comparable<Count> {

        private final int key;
        private final int value;

        public Count(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Count o) {
            return o.value - this.value;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // counterMap = (-1,2) (1,1) (2,2) (3,1) (4,1)
        PriorityQueue<Count> priorityQueue = new PriorityQueue<>();

        for (int key : countMap.keySet()) {
            priorityQueue.add(new Count(key, countMap.get(key)));
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = priorityQueue.poll().key;
        }

        return answer;
    }
}
