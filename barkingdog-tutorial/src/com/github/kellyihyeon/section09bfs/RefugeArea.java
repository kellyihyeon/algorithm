package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RefugeArea {

    private static int n;
    private static int[][] area;
    private static boolean[][] visited;
    private static int[] dirX = {1, 0, -1, 0};
    private static int[] dirY = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        area = new int[n][n];
        visited = new boolean[n][n];

        int maxAreaHeight = 1;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                int height = Integer.parseInt(s[j]);
                area[i][j] = height;

                maxAreaHeight = Math.max(maxAreaHeight, height);
            }
        }

        int max = 0;
        for (int target = 0; target <= maxAreaHeight; target++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] || area[i][j] <= target) continue;

                    bfs(i, j, target);
                    count++;
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    private static void bfs(int x, int y, int target) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int nextX = curX + dirX[dir];
                int nextY = curY + dirY[dir];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
                if (area[nextX][nextY] <= target || visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                queue.offer(new int[]{nextX, nextY});
            }
        }
    }

}
