package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 토마토 상자에 토마토가 들어있다.
 * 보관 후 하루가 지나면 익은 토마토와 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
 * 인접한 위치: 상,하,좌,우
 * 상자에 들어있는 토마토들이 며칠이 지나면 모두 익는지, 최소 일수를 구하라.
 * 1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토 없음
 */
public class Tomato {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[1]);
        int m = Integer.parseInt(line[0]);

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] box = new int[n][m];
        int[][] days = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] rows = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(rows[j]);

                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }

                if (box[i][j] == 0) {
                    days[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (days[nx][ny] >= 0) continue;

                days[nx][ny] = days[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (days[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }

                max = Math.max(max, days[i][j]);
            }
        }
        System.out.println(max);
    }
}
