package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 직사각형을 제외한 나머지 부분이 몇개의 영역으로 분리되는지 출력
 * 분리된 각 영역의 넓이가 얼마인지 출력
 *
 */
public class AreaCalculator {

    public static void main(String[] args) throws IOException {
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int recTotal = Integer.parseInt(st.nextToken());

        int[][] board = new int[row][col];
        boolean[][] visited = new boolean[row][col];


        // 주어진 사각형 영역을 -1로 표시
        for (int i = 0; i < recTotal; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for (int j = startY; j < endY; j++) {
                for (int k = startX; k < endX; k++) {
                    board[j][k] = -1;
                }
            }
        }

        // BFS
        int count = 0;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == -1 || visited[i][j]) continue;

                Queue<int[]> queue = new LinkedList<>();
                visited[i][j] = true;
                queue.offer(new int[]{i, j});

                int width = 1;
                count++;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int curX = cur[0];
                    int curY = cur[1];

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = curX + dirX[dir];
                        int ny = curY + dirY[dir];

                        if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                        if (board[nx][ny] == -1 || visited[nx][ny]) continue;

                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        width++;
                    }
                }
                answer.add(width);
            }
        }

        // 영역의 개수
        System.out.println(count);
        // 영역의 넓이
        Collections.sort(answer);
        for (Integer a : answer) {
            System.out.print(a + " ");
        }
    }

}
