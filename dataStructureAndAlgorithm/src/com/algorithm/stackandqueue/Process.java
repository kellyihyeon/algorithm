package com.algorithm.stackandqueue;

import java.util.*;

public class Process {

    class Job {
        boolean isTarget;
        int priority;

        public Job(boolean isTarget, int priority) {
            this.isTarget = isTarget;
            this.priority = priority;
        }
    }


    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

//        int answer = new Process().solution(priorities2, location2);
//        System.out.println(answer);

        int answer2 = new Process().useObject(priorities, location);
        System.out.println("answer2 = " + answer2);

    }

    public int useObject(int[] priorities, int location) {
        List<Job> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            boolean isTarget = i == location;
            queue.add(new Job(isTarget, priorities[i]));
        }

        int count = 0;

        while (!queue.isEmpty()) {
            Job now = queue.remove(0);
            boolean printable = true;

            for (Job job : queue) {
                if (now.priority < job.priority) {
                    printable = false;
                    break;
                }
            }

            if (!printable) {
                queue.add(now);
                continue;
            }

            count++;
            if (now.isTarget) {
                return count;
            }
        }

        return count;
    }

    public int solution(int[] priorities, int location) {
        Queue<Integer> process = new LinkedList<>();
        Queue<Integer> priority = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            process.offer(i + 1);
            priority.offer(priorities[i]);
        }

        int target = location + 1;
        int execution = 0;

        while (priority.size() > 1) {
            Integer processPoll = process.poll();
            Integer priorityPoll = priority.poll();

            boolean checker = priority.stream().anyMatch(num -> num > priorityPoll);

            if (checker) {
                process.offer(processPoll);
                priority.offer(priorityPoll);
            } else {
                execution++;
                if (processPoll == target) {
                    return execution;
                }
            }
        }

        return execution + 1;
    }
}
