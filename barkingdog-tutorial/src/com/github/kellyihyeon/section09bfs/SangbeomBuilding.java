package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SangbeomBuilding {

    private static int[] dirX = {1, 0, -1, 0, 0, 0};
    private static int[] dirY = {0, 1, 0, -1, 0, 0};
    private static int[] dirF = {0, 0, 0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int z = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (z == 0 && x == 0 && y == 0) break;

            char[][][] building = new char[z][x][y];
            int[][][] distance = new int[z][x][y];

            for (int i = 0; i < z; i++) {
                for (int j = 0; j < x; j++) {
                    char[] lines = br.readLine().toCharArray();

                    for (int k = 0; k < y; k++) {
                        building[i][j][k] = lines[k];
                    }
                }
                br.readLine();
            }

            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < x; j++) {
                    for (int k = 0; k < y; k++) {
                        if (building[i][j][k] == 'S') {
                            queue.offer(new int[]{i, j, k});
                        }
                    }
                }
            }

            int minute = 0;
            boolean isExit = false;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int curZ = current[0];
                int curX = current[1];
                int curY = current[2];

                for (int dir = 0; dir < 6; dir++) {
                    int nextZ = curZ + dirF[dir];
                    int nextX = curX + dirX[dir];
                    int nextY = curY + dirY[dir];

                    if (nextX < 0 || nextX >= x || nextY < 0 || nextY >= y || nextZ < 0 || nextZ >= z) continue;
                    if (building[nextZ][nextX][nextY] == '#' || distance[nextZ][nextX][nextY] > 0) continue;

                    distance[nextZ][nextX][nextY] = distance[curZ][curX][curY] + 1;

                    if (building[nextZ][nextX][nextY] == 'E') {
                        minute = distance[nextZ][nextX][nextY];
                        System.out.println("Escaped in " + minute + " minute(s).");
                        isExit = true;
                        break;
                    }

                    queue.offer(new int[]{nextZ, nextX, nextY});
                }
            }

            if (!isExit) {
                System.out.println("Trapped!");
            }
        }
    }
}
