package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();
        visited[n] = true;
        queue.offer(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int location = cur[0];
            int depth = cur[1];
            int[] dir = {1, -1, location};

            if (location == k){
                System.out.println(depth);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nextLocation = location + dir[i];

                if (nextLocation >= 0 && nextLocation <= 100000 && !visited[nextLocation]) {
                    visited[nextLocation] = true;
                    queue.offer(new int[]{nextLocation, depth + 1});
                }
            }
        }
    }

}
