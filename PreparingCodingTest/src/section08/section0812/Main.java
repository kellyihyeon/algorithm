package section08.section0812;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int[] dx = {-1, 0, 1, 0};   // 행
    private static int[] dy = {0, 1, 0, -1};   // 열

    private static int[][] board;
    private static int[][] distance;

    private static int n;
    private static int m;

    private static Queue<Point> queue = new LinkedList<>();

    public void BFS() {
        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = tmp.getX() + dx[i];
                int nextY = tmp.getY() + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && board[nextX][nextY] == 0) {
                    board[nextX][nextY] = 1;
                    queue.offer(new Point(nextX, nextY));
                    distance[nextX][nextY] = distance[tmp.getX()][tmp.getY()] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        m = scanner.nextInt();
        n = scanner.nextInt();

        board = new int[n][m];
        distance = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
                if (board[i][j] == 1) {
                    // 익은 토마토들이 동시에(같은 level 선상 출발점이 여러 개) 퍼져야 하기 때문에 BFS 돌기 전에 queue 에 미리 담아 놓는다.
                    queue.offer(new Point(i, j));
                }

            }
        }
        M.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    flag = false;
                }
            }
        }

        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, distance[i][j]);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
