package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Red/Green/Blue 별로 색이 나뉘어져있을 때
 * 보통인이 봤을 때 그림 개수와 적록색약인 사람이 봤을 때의 그림 개수를 출력하라.
 */
public class CowArt {
    // 20 -> 00 : 18시 10분에 보통인 케이스1은 풀었고, 19분에 케이스2 풀이법 생각해냄.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        char[][] board2 = new char[n][n];

        // 보통인의 그림 보드
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = chars[j];
            }
        }

        // 적록색약인의 그림 보드
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char color;
                if (board[i][j] == 'G') {
                    color = 'R';
                } else {
                    color = board[i][j];
                }

                board2[i][j] = color;
            }
        }


        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;

                visited[i][j] = true;
                queue.offer(new int[]{i, j});

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dirX[dir];
                        int ny = cur[1] + dirY[dir];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (visited[nx][ny]) continue;
                        if (board[cur[0]][cur[1]] != board[nx][ny]) continue;

                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }

                count++;

            }
        }

        boolean[][] visited2 = new boolean[n][n];
        Queue<int[]> queue2 = new LinkedList<>();

        int count2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited2[i][j]) continue;

                visited2[i][j] = true;
                queue2.offer(new int[]{i, j});

                while (!queue2.isEmpty()) {
                    int[] cur = queue2.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dirX[dir];
                        int ny = cur[1] + dirY[dir];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (visited2[nx][ny]) continue;
                        if (board2[cur[0]][cur[1]] != board2[nx][ny]) continue;

                        visited2[nx][ny] = true;
                        queue2.offer(new int[]{nx, ny});
                    }
                }

                count2++;
            }
        }

        System.out.println(count + " " + count2);
    }

}
