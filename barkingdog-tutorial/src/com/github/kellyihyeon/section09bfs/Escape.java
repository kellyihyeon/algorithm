package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 건물에서 불이 났을 때 상근이가 얼마나 빨리 빌딩을 탈출할 수 있는지 구하라.
 * 상근이와 불이 이동할 수 있는 경로: 동서남북 인접한 칸
 */
public class Escape {

    public static void main(String[] args) throws IOException {
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int column = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());

            char[][] board = new char[row][column];
            int[][] distanceOfFire = new int[row][column];
            int[][] distanceOfPerson = new int[row][column];


            Queue<int[]> queueF = new LinkedList<>();
            Queue<int[]> queueP = new LinkedList<>();

            for (int i = 0; i < row; i++) {
                String line = br.readLine();
                for (int j = 0; j < column; j++) {
                    char c = line.charAt(j);
                    board[i][j] = c;

                    if (c == '*') {
                        distanceOfFire[i][j] = 1;
                        queueF.offer(new int[]{i, j});
                    } else if (c == '@') {
                        distanceOfPerson[i][j] = 1;
                        queueP.offer(new int[]{i, j});
                    }
                }
            }

            // 불의 BFS
            while (!queueF.isEmpty()) {
                int[] cur = queueF.poll();
                int curX = cur[0];
                int curY = cur[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nx = curX + dirX[dir];
                    int ny = curY + dirY[dir];

                    if (nx < 0 || nx >= row || ny < 0 || ny >= column) continue;
                    if (board[nx][ny] == '#') continue;
                    if (distanceOfFire[nx][ny] != 0) continue;

                    distanceOfFire[nx][ny] = distanceOfFire[curX][curY] + 1;
                    queueF.offer(new int[]{nx, ny});
                }
            }

            // 상근이의 BFS
            boolean isEscape = false;
            while (!queueP.isEmpty() && !isEscape) {
                int[] cur = queueP.poll();
                int curX = cur[0];
                int curY = cur[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nx = curX + dirX[dir];
                    int ny = curY + dirY[dir];

                    if (nx < 0 || nx >= row || ny < 0 || ny >= column) {
                        System.out.println(distanceOfPerson[curX][curY]);
                        isEscape = true;
                        break;
                    }

                    if (board[nx][ny] == '#') continue;
                    if (distanceOfPerson[nx][ny] != 0 ) continue;
                    // 불이 도달한 위치라면 불이 사람보다 더 빨리 도달했는지 확인
                    if (distanceOfFire[nx][ny] != 0 && distanceOfFire[nx][ny] <= distanceOfPerson[curX][curY] + 1) continue;

                    distanceOfPerson[nx][ny] = distanceOfPerson[curX][curY] + 1;
                    queueP.offer(new int[]{nx, ny});
                }
            }

            if (!isEscape) {
                System.out.println("IMPOSSIBLE");
            }

        }

    }

}
