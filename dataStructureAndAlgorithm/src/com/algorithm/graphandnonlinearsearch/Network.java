package com.algorithm.graphandnonlinearsearch;

import java.util.Stack;

public class Network {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int n2 = 3;
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        int answer = new Network().solution(n2, computers2);
        System.out.println("answer = " + answer);
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            answer++;
            visitAllConnectedComputers(computers, visited, i);
        }

        return answer;
    }

    private void visitAllConnectedComputers(int[][] computers, boolean[] visited, int c) {
        Stack<Integer> stack = new Stack<>();
        stack.push(c);

        while (!stack.isEmpty()) {
            int i = stack.pop();
            visited[i] = true;

            for (int j = 0; j < computers.length; j++) {
                if (visited[j]) {
                    continue;
                }

                if (computers[i][j] == 1) {
                    stack.push(j);
                }
            }
        }
    }
}
