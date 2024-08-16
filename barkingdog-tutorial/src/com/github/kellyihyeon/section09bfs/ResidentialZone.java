package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ResidentialZone {

    public static void main(String[] args) throws IOException {
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 1 || visited[i][j]) continue;
                Queue<int[]> queue = new LinkedList<>();

                int house = 1;
                visited[i][j] = true;
                queue.offer(new int[]{i, j});

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dirX[dir];
                        int ny = cur[1] + dirY[dir];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (board[nx][ny] == 0 || visited[nx][ny]) continue;

                        house++;
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
                count++;
                answer.add(house);
            }
        }

        System.out.println(count);

        Collections.sort(answer);
        for (Integer area : answer) {
            System.out.println(area);
        }
    }
}
