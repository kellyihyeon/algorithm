package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class OrganicCabbage {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};

        for (int t = 0; t < testCase; t++) {
            String[] line = br.readLine().split(" ");
            int row = Integer.parseInt(line[0]);
            int column = Integer.parseInt(line[1]);
            int totalCabbage = Integer.parseInt(line[2]);

            int[][] board = new int[row][column];
            boolean[][] visited = new boolean[row][column];

            for (int i = 0; i < totalCabbage; i++) {
                String[] target = br.readLine().split(" ");
                int x = Integer.parseInt(target[0]);
                int y = Integer.parseInt(target[1]);

                board[x][y] = 1;
            }

            Queue<int[]> queue = new LinkedList<>();
            int count = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (board[i][j] == 0 || visited[i][j]) continue;

                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dirX[dir];
                            int ny = cur[1] + dirY[dir];

                            if (nx < 0 || nx >= row || ny < 0 || ny >= column) continue;
                            if (board[nx][ny] == 0 || visited[nx][ny]) continue;

                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                    count++;
                }
            }

            System.out.println(count);
        }

    }
}
