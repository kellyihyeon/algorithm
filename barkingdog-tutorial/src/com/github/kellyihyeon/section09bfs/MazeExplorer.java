package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * (1,1)에서 출발하여 (n,m)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하라.
 * 서로 인접한 칸으로만 이동 가능.
 */
public class MazeExplorer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }

        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], -1);
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        distance[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (distance[nx][ny] >= 0 || board[nx][ny] != 1) continue;

                distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        System.out.println(distance[n - 1][m - 1] + 1);
    }
}


