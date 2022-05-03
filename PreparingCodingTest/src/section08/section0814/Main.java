package section08.section0814;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 섬나라 아일랜드(BFS)
 */
public class Main {

    private static int answer = 0;
    private static int n;

    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    private static int[][] board;
    Queue<Point> queue = new LinkedList<>();


    private void BFS(int x, int y) {
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point pos = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nextX = pos.x + dx[i];
                int nextY = pos.y + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && board[nextX][nextY] == 1) {
                    board[nextX][nextY] = 0;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }

    }

    private void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    BFS(i, j);
                }
            }
        }

    }


    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        M.solution();
        System.out.println(answer);



    }
}

class Point {

    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
