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

        int[] answers2 = new ApiRelease().solution2(progresses2, speeds2);
        System.out.println("answers2 = " + Arrays.toString(answers2));
    }

    public int[] solution2(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            days.offer((int) Math.ceil((100 - (float) progresses[i]) / (float) speeds[i]));
        }

        int count = 1;
        List<Integer> answer = new LinkedList<>();
        int standard = days.poll();

        while (!days.isEmpty()) {
            int compare = days.poll();
            if (standard >= compare) {
                count++;
            } else {
                standard = compare;
                answer.add(count);
                count = 1;
            }
        }

        answer.add(count);

        return answer.stream().mapToInt(Integer::intValue).toArray();
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
