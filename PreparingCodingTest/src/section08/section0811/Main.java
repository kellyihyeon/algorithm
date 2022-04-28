package section08.section0811;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int[][] board;
    private static int[][] distance;

    private static final int[] dx = {-1, 0, 1, 0};    // 행
    private static final int[] dy = {0, 1, 0, -1};    // 열



    private void BFS(int x, int y) {    // b(1,1)
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));   // (1,1)

        // 출발점: 1로 체크
        board[x][y] = 1;

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();  // (1,2) 레벨 정보도 필요한 것 같은데
            for (int i = 0; i < 4; i++) {
                int nextX = tmp.getX() + dx[i];
                int nextY = tmp.getY() + dy[i];

                if (nextX >= 1 && nextX <= 7 && nextY >= 1 && nextY <= 7 && board[nextX][nextY] == 0) {
                    board[nextX][nextY] = 1;    // 1로 체크
                    queue.offer(new Point(nextX, nextY));
                    distance[nextX][nextY] = distance[tmp.getX()][tmp.getY()] + 1;
                }
            }


        }

   }


    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        board = new int[8][8];
        distance = new int[8][8];

        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        M.BFS(1, 1);

        if (distance[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(distance[7][7]);
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
