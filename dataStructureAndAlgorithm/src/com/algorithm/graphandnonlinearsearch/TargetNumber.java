package com.algorithm.graphandnonlinearsearch;

public class TargetNumber {

    int answer;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int answer = new TargetNumber().solution(numbers, target);
        System.out.println("answer = " + answer);
    }

    public int solution(int[] numbers, int target) {
        return dfs2(numbers, target, 0, 0);
    }

    public int dfs2(final int[] numbers, final int target, int index, int sum) {
        // 1. 탈출 조건
        if (index == numbers.length) {
            if (target == sum) {
                answer++;
            }
            return answer;
        }

        // 2. 수행 동작
        dfs2(numbers, target, index + 1, sum + numbers[index]);
        dfs2(numbers, target, index + 1, sum - numbers[index]);

        return answer;
    }

    public int dfs(final int[] numbers, final int target, int depth, int sum) {
        // 마지막 노드까지 탐색한 경우
        if (depth == numbers.length) {
            if (target == sum) {
                return 1;
            }
            return 0;
        }

        return dfs(numbers, target, depth + 1, sum + numbers[depth]) +
                dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }
}
