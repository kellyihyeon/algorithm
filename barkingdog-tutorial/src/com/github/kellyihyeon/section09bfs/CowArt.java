package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Red/Green/Blue 별로 색이 나뉘어져있을 때
 * 보통인이 봤을 때 그림 개수와 적록색약인 사람이 봤을 때의 그림 개수를 출력하라.
 */
public class CowArt {

    private static int n;
    private static char[][] board;
    private static boolean[][] visited;
    private final static int[] dirX = {1, 0, -1, 0};
    private final static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        visited = new boolean[n][n];

        // 보통인의 그림 보드
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = chars[j];
            }
        }
        int normal = countImagePieces();

        // 방문 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }

        // 적록색약인의 그림 보드
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'R';
                }
            }
        }
        int redGreenColorBlindness = countImagePieces();

        System.out.println(normal + " " + redGreenColorBlindness);
    }

    private static int countImagePieces() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                bfs(i, j);
                count++;
            }
        }
        return count;
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        visited[x][y] = true;
        queue.offer(new int[]{x, y});

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
    }
}

