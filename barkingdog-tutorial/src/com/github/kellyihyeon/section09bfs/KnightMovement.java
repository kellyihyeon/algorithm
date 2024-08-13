package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 나이트의 현재 위치에서 목표 위치까지 몇 번만에 이동할 수 있는가?
 * 나이트의 이동 방향은 8가지
 * (x-1,y-2)(x-2,y-1)  (x-2,y+1)(x-1,y+2)
 * (x+1,y-2)(x+2,y-1) (x+2,y+1) (x+1,y+2)
 */
public class KnightMovement {

    public static void main(String[] args) throws IOException {
        int[] dirX = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] dirY = {1, 2, 2, 1, -1, -2, -2, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            int[][] distance = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(distance[i], -1);
            }

            Queue<int[]> queue = new LinkedList<>();
            distance[x][y] = 0;
            queue.offer(new int[]{x, y});

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];

                for (int dir = 0; dir < 8; dir++) {
                    int nx = curX + dirX[dir];
                    int ny = curY + dirY[dir];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (distance[nx][ny] >= 0) continue;

                    distance[nx][ny] = distance[curX][curY] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
            System.out.println(distance[targetX][targetY]);

        }
    }
}
