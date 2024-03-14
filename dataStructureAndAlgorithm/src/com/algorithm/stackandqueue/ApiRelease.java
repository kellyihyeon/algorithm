package com.algorithm.stackandqueue;

import java.util.*;

public class ApiRelease {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] progresses2 = {93, 30, 55};
        int[] speeds2 = {1, 30, 5};

        int[] answers = new ApiRelease().solution(progresses, speeds);
        System.out.println(Arrays.toString(answers));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] restProgress = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            restProgress[i] = 100 - progresses[i];
        }

        int[] deadlines = new int[speeds.length];
        for (int i = 0; i < speeds.length; i++) {
            deadlines[i] = (int) Math.ceil((double)restProgress[i] / speeds[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int deadline : deadlines) {
            queue.offer(deadline);
        }

        int deadline = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            Integer peek = queue.peek();

            if (deadline != 0) {
                poll = deadline;
            }

            if (peek == null) {
                peek = 0;
            }

            if (poll < peek) {
                map.put(poll, map.getOrDefault(poll, 0) + 1);
                deadline = 0;
            } else {
                deadline = poll;
                map.put(deadline, map.getOrDefault(deadline, 0) + 1);
            }
        }

        List<Integer> answer = new LinkedList<>();
        for (Integer value : map.values()) {
            answer.add(value);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
