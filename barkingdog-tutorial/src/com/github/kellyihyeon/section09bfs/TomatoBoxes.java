package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 토마토 상자들을 수직으로 쌓아 올려서 보관할 때, 토마토가 익는 최소 일수를 구하라.
 * 1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토 없음
 * 애초에 토마토가 모두 익어있는 상태면 0 출력, 익지 못하는 상태면 -1 출력
 *
 */
public class TomatoBoxes {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int col = Integer.parseInt(line[0]);
        int row = Integer.parseInt(line[1]);
        int height = Integer.parseInt(line[2]);

        int[] dirX = {1, 0, -1, 0, 0, 0};
        int[] dirY = {0, 1, 0, -1, 0, 0};
        int[] dirZ = {0, 0, 0, 0, 1, -1};

        int[][][] board = new int[height][row][col];
        int[][][] distance = new int[height][row][col];

        Queue<int[]> queue = new LinkedList<>();


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < row; j++) {
                String[] nums = br.readLine().split(" ");
                for (int k = 0; k < col; k++) {
                    int num = Integer.parseInt(nums[k]);
                    board[i][j][k] = num;
                    if (num == 1) {
                        queue.offer(new int[]{i, j, k});
                    } else if (num == 0) {
                        distance[i][j][k] = -1;     // 익지 않은 토마토 -1로 세팅하기
                    }
                }
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curZ = cur[0];
            int curX = cur[1];
            int curY = cur[2];


            for (int dir = 0; dir < 6; dir++) {
                int nz = curZ + dirZ[dir];
                int nx = curX + dirX[dir];
                int ny = curY + dirY[dir];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col || nz < 0 || nz >= height) continue;
                if (distance[nz][nx][ny] >= 0) continue;

                distance[nz][nx][ny] = distance[curZ][curX][curY] + 1;
                queue.offer(new int[]{nz, nx, ny});
            }
        }

        int answer = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (distance[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }

                    answer = Math.max(answer, distance[i][j][k]);
                }
            }
        }

        System.out.println(answer);
    }

}


