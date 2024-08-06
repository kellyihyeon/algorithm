package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Fire {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        char[][] board = new char[n][m];
        int[][] exit = new int[n][m];
        int[][] fire = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(exit[i], -1);
            Arrays.fill(fire[i], -1);
        }

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = chars[j];
            }
        }

        Queue<int[]> queueJ = new LinkedList<>();
        Queue<int[]> queueF = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'J') {
                    queueJ.offer(new int[]{i, j});
                    exit[i][j] = 0;
                }

                if (board[i][j] == 'F') {
                    queueF.offer(new int[]{i, j});
                    fire[i][j] = 0;
                }
            }
        }

        // 불의 경우
        while (!queueF.isEmpty()) {
            int[] cur = queueF.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (fire[nx][ny] >= 0 || board[nx][ny] == '#') continue;

                fire[nx][ny] = fire[cur[0]][cur[1]] + 1;
                queueF.offer(new int[]{nx, ny});
            }
        }

        // 지훈이의 경우
        while (!queueJ.isEmpty()) {
            int[] cur = queueJ.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    System.out.println(exit[cur[0]][cur[1]] + 1);
                    return;
                }

                if (exit[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                if (fire[nx][ny] != -1 && fire[nx][ny] <= exit[cur[0]][cur[1]] + 1) continue;

                exit[nx][ny] = exit[cur[0]][cur[1]] + 1;
                queueJ.offer(new int[]{nx, ny});
            }
        }

        System.out.println("IMPOSSIBLE");

    }
}
