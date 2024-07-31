package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 도화지에 그림이 그려져 있을 때, 연결된 그림의 개수와 그림 넓이가 가장 넓은 것의 넓이를 구하라.
 * 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미
 */
public class Picture {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[1]);  // 5
        int m = Integer.parseInt(size[0]);  // 6

        int[][] boards = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                boards[i][j] = Integer.parseInt(row[j]);
            }
        }

        boolean[][] visited = new boolean[m][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int totalOfPicture = 0;
        int maxOfArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (boards[i][j] == 0 || visited[i][j]) continue;

                totalOfPicture++;
                Queue<int[]> queue = new LinkedList<>();
                visited[i][j] = true;
                queue.offer(new int[]{i, j});

                int area = 0;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    area++;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if (visited[nx][ny] || boards[nx][ny] != 1) continue;

                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
                maxOfArea = Math.max(maxOfArea, area);
            }
        }

        System.out.println(totalOfPicture);
        System.out.println(maxOfArea);
    }
}
